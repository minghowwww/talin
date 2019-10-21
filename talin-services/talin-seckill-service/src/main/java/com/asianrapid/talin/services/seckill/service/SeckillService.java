package com.asianrapid.talin.services.seckill.service;

import com.alibaba.fastjson.JSONObject;
import com.asianrapid.talin.common.consts.SystemMessageConst;
import com.asianrapid.talin.common.domain.dbo.SeckillItem;
import com.asianrapid.talin.common.domain.common.BaseResponse;
import com.asianrapid.talin.common.domain.dto.seckill.RushDTO;
import com.asianrapid.talin.common.utils.RedisUtil;
import com.asianrapid.talin.services.seckill.config.AccessLimitService;
import com.asianrapid.talin.services.seckill.dao.SeckillItemDao;
import com.asianrapid.talin.services.seckill.producer.SeckillProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;

import java.util.List;

/**
 * @ClassName SeckillService
 * @Description: 秒杀服务逻辑层
 * @Author Nio
 * @Date 2019/9/13 0013
 * @Version V1.0
 **/
@Service
public class SeckillService {

    private final AccessLimitService accessLimitService;
    private final RedisUtil redisUtil;
    private final SeckillProducer seckillProducer;
    private final SeckillItemDao seckillItemDao;

    @Autowired
    public SeckillService(AccessLimitService accessLimitService, RedisUtil redisUtil, SeckillProducer seckillProducer, SeckillItemDao seckillItemDao) {
        this.accessLimitService = accessLimitService;
        this.redisUtil = redisUtil;
        this.seckillProducer = seckillProducer;
        this.seckillItemDao = seckillItemDao;
    }

    public BaseResponse<String> rush(RushDTO rushDTO) {
        // 1.限流
        if (accessLimitService.tryAcquire()) {
            // 2.redis中减库存
            // 先获取当前商品在此次活动中的库存总数
            String total = redisUtil.getString(generateRedisKey(rushDTO.getActivityId(), rushDTO.getItemId(), "total"));
            Long stock = NumberUtils.parseNumber(total, Long.class);
            String redisKey = generateRedisKey(rushDTO.getActivityId(), rushDTO.getItemId());
            // activityId_itemId:[userId,userId,userId]
            Long setSize = redisUtil.getSetSize(redisKey);
            if (setSize.equals(stock)) {
                return BaseResponse.ok(SystemMessageConst.INSUFFICIENT_INVENTORY);
            }
            Long flag = redisUtil.addSet(redisKey, String.valueOf(rushDTO.getUserId()));
            if (flag == 0) {
                return BaseResponse.ok(SystemMessageConst.REPEAT_PURCHASE);
            }

            // 3.mq投递请求，消费端创建订单
            sendSeckillMsg(rushDTO);
            return BaseResponse.ok(SystemMessageConst.SECKILL_SUCCESS);
        } else {
            return BaseResponse.ok(SystemMessageConst.SERVER_BUSY);
        }

    }

    public BaseResponse<String> syncStock(String activityId) {
        // 将数据库中商品库存数据存到redis中  activityId_itemId_total: number
        List<SeckillItem> seckillItems = seckillItemDao.findByActivityId(NumberUtils.parseNumber(activityId, Long.class));
        seckillItems.forEach(v -> {
            redisUtil.setString(generateRedisKey(String.valueOf(v.getActivityId()), String.valueOf(v.getItemId()), "total"), String.valueOf(v.getNumber()));
        });
        return BaseResponse.ok();
    }

    private String generateRedisKey(String... key) {
        StringBuilder value = new StringBuilder();
        for (int i = 0; i < key.length; i++) {
            if (i > 0) {
                value.append("_").append(key[i]);
            } else {
                value.append(key[i]);
            }
        }
//        for (String item : key) {
//            value.append("_").append(item);
//        }
        return value.toString();
    }

    /**
     * 获取到秒杀token之后，异步放入mq中实现修改商品的库存
     */
    @Async
    protected void sendSeckillMsg(RushDTO rushDTO) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("activityId", rushDTO.getActivityId());
        jsonObject.put("userId", rushDTO.getUserId());
        jsonObject.put("itemId", rushDTO.getItemId());
        seckillProducer.send(jsonObject);
    }


}
