package com.asianrapid.talin.services.integral.consumer;

import com.alibaba.fastjson.JSONObject;
import com.asianrapid.talin.common.consts.SystemConst;
import com.asianrapid.talin.common.domain.Integral;
import com.asianrapid.talin.common.service.BaseService;
import com.asianrapid.talin.services.integral.dao.IntegralDao;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author Nio
 */
@Component
@Slf4j
public class IntegralConsumer extends BaseService {
	@Autowired
	private IntegralDao integralDao;

	@RabbitListener(queues = SystemConst.INTEGRAL_DIC_QUEUE)
	public void process(Message message, @Headers Map<String, Object> headers, Channel channel) throws IOException {
		try {
			String messageId = message.getMessageProperties().getMessageId();
			String msg = new String(message.getBody(), StandardCharsets.UTF_8);
			log.debug(">>>messageId:{},msg:{}", messageId, msg);
			JSONObject jsonObject = JSONObject.parseObject(msg);
			String paymentId = jsonObject.getString("paymentId");
			if (StringUtils.isEmpty(paymentId)) {
				debugLog(">>>>支付id不能为空 paymentId:{}", paymentId);
				basicNack(message, channel);
				return;
			}
			// 使用paymentId查询是否已经增加过积分 网络重试间隔
			Integral resultIntegralEntity = integralDao.findByPaymentId(paymentId);
			if (resultIntegralEntity != null) {
				debugLog(">>>>paymentId:{}已经增加过积分", paymentId);
				// 已经增加过积分，通知MQ不要在继续重试。
				basicNack(message, channel);
				return;
			}
			Integer userId = jsonObject.getInteger("userId");
			if (userId == null) {
				debugLog(">>>>paymentId:{},对应的用户userId参数为空", paymentId);
				basicNack(message, channel);
				return;
			}
			Long integral = jsonObject.getLong("integral");
			if (integral == null) {
				debugLog(">>>>paymentId:{},对应的用户integral参数为空", integral);
				return;
			}
			Integral integralEntity = new Integral();
			integralEntity.setPaymentId(paymentId);
			integralEntity.setIntegral(String.valueOf(integral));
			integralEntity.setUserId(userId);
			integralEntity.setAvailability(1);
			// 插入到数据库中
			Integral save = integralDao.save(integralEntity);
			if (save != null) {
				// 手动签收消息,通知mq服务器端删除该消息
				basicNack(message, channel);
			}
			// 采用重试机制
		} catch (Exception e) {
			errorLog("增加积分失败", e);
			basicNack(message, channel);
		}

	}

	/**
	 * 消费者获取到消息之后 手动签收 通知MQ删除该消息
	 * @param message
	 * @param channel
	 * @throws IOException
	 */
	private void basicNack(Message message, Channel channel) throws IOException {
		channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
	}

}
