package com.asianrapid.talin.consumers.seckill;

import com.alibaba.fastjson.JSONObject;
import com.asianrapid.talin.common.domain.dbo.SeckillItem;
import com.asianrapid.talin.common.domain.dbo.SeckillOrder;
import com.asianrapid.talin.consumers.seckill.config.RabbitmqConfig;
import com.asianrapid.talin.consumers.seckill.dao.SeckillItemDao;
import com.asianrapid.talin.consumers.seckill.dao.SeckillOrderDao;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.statement.execute.Execute;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

/**
 * @ClassName SeckillOrderConsumer
 * @Description: 秒杀服务消费者
 * @Author Nio
 * @Date 2019/9/16 0016
 * @Version V1.0
 **/
@Component
@Slf4j
public class SeckillOrderConsumer {

    private final SeckillItemDao seckillItemDao;
    private final SeckillOrderDao seckillOrderDao;

    @Autowired
    public SeckillOrderConsumer(SeckillItemDao seckillItemDao, SeckillOrderDao seckillOrderDao) {
        this.seckillItemDao = seckillItemDao;
        this.seckillOrderDao = seckillOrderDao;
    }

    /**
     * 修改库存并新增秒杀订单
     * @param message
     * @param headers
     * @param channel
     * @throws IOException
     */
    @Transactional(rollbackFor = Exception.class)
    @RabbitListener(queues = RabbitmqConfig.SECKILL_ORDER_QUEUE)
    public void process(Message message, @Headers Map<String, Object> headers, Channel channel) throws IOException {
        String messageId = message.getMessageProperties().getMessageId();
        String msg = new String(message.getBody(), StandardCharsets.UTF_8);
        log.debug(">>>messageId:{},msg:{}", messageId, msg);
        JSONObject jsonObject = JSONObject.parseObject(msg);
        Long activityId = jsonObject.getLong("activityId");
        Long itemId = jsonObject.getLong("itemId");
        //修改库存
        Integer seckillItem = seckillItemDao.updateItemNumbers(activityId, itemId);
        if (!new Integer(1).equals(seckillItem)) {
            log.error("库存数修改失败");
            return;
        }
        // 2.添加秒杀订单
        SeckillItem item = seckillItemDao.findByActivityIdAndItemId(activityId, itemId);
        Long userId = jsonObject.getLong("userId");
        SeckillOrder seckillOrder = new SeckillOrder(activityId, userId, item.getPrice(), 1L, itemId, userId, new Date(), userId, new Date());
        SeckillOrder order = seckillOrderDao.save(seckillOrder);
        if (order == null) {
            return;
        }
        log.debug("秒杀成功, 订单id:{}, 活动id:{}, 用户id:{}", seckillOrder.getOrderId(), activityId, userId);
    }

}
