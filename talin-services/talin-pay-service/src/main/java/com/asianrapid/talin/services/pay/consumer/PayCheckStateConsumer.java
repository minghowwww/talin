package com.asianrapid.talin.services.pay.consumer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import com.asianrapid.talin.common.consts.SystemConst;
import com.asianrapid.talin.common.domain.dbo.PaymentTransaction;
import com.asianrapid.talin.common.service.BaseService;
import com.asianrapid.talin.services.pay.dao.PaymentTransactionDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;

import lombok.extern.slf4j.Slf4j;

/**
 * 支付回调检查状态，是否为已经支付完成
 *
 * @author Nio
 */
@Component
@Slf4j
public class PayCheckStateConsumer extends BaseService {
	@Autowired
	private PaymentTransactionDao paymentTransactionDao;

	// 死信队列（备胎） 消息被拒绝、队列长度满了 定时任务 人工补偿

	@RabbitListener(queues = SystemConst.PAYMENT_COMPENSATE_QUEUE)
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
			// 1.使用paymentId查询之前是否已经支付过
			PaymentTransaction paymentTransactionEntity = paymentTransactionDao.findByPaymentId(paymentId);
			if (paymentTransactionEntity == null) {
				log.error(">>>>支付id paymentId:{} 未查询到", paymentId);
				basicNack(message, channel);
				return;
			}
			Long paymentStatus = paymentTransactionEntity.getPaymentStatus();
			if (paymentStatus.equals(SystemConst.PAY_STATUS_SUCCESS)) {
				log.error(">>>>支付id paymentId:{} ", paymentId);
				basicNack(message, channel);
				return;
			}
			// 安全期间 主动调用第三方接口查询
			Long paymentChannel = jsonObject.getLong("paymentChannel");
			PaymentTransaction paymentTransaction = new PaymentTransaction();
			paymentTransaction.setPaymentId(paymentId);
			paymentTransaction.setPaymentStatus(SystemConst.PAY_STATUS_SUCCESS);
			paymentTransaction.setPaymentChannel(paymentChannel);
			PaymentTransaction updatePaymentStatus = paymentTransactionDao.saveAndFlush(paymentTransaction);
			if (updatePaymentStatus != null) {
				basicNack(message, channel);
				return;
			}
			// 继续重试

		} catch (Exception e) {
			errorLog("", e);
			basicNack(message, channel);
		}

	}

	private void basicNack(Message message, Channel channel) throws IOException {
		channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);

	}

}
