package com.asianrapid.talin.services.seckill.producer;

import com.alibaba.fastjson.JSONObject;
import com.asianrapid.talin.services.seckill.config.RabbitmqConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * 秒杀生产者
 * @author Nio
 */
@Component
@Slf4j
public class SeckillProducer implements RabbitTemplate.ConfirmCallback {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void send(JSONObject jsonObject) {

		String jsonString = jsonObject.toJSONString();
		log.debug("jsonString:{}", jsonString);
		String messAgeId = UUID.randomUUID().toString().replace("-", "");
		// 封装消息
		Message message = MessageBuilder.withBody(jsonString.getBytes())
				.setContentType(MessageProperties.CONTENT_TYPE_JSON).setContentEncoding(String.valueOf(StandardCharsets.UTF_8)).setMessageId(messAgeId)
				.build();
		// 构建回调返回的数据（消息id）
		this.rabbitTemplate.setMandatory(true);
		this.rabbitTemplate.setConfirmCallback(this);
		CorrelationData correlationData = new CorrelationData(jsonString);
		rabbitTemplate.convertAndSend(RabbitmqConfig.SECKILL_EXCHANGE_NAME, "seckill", message, correlationData);

	}

	/**
	 * 生产消息确认机制 生产者往服务器端发送消息的时候，采用应答机制
	 *
	 * @param correlationData
	 * @param ack
	 * @param cause
	 */
	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		String jsonString = correlationData.getId();
		log.debug("消息id:{}", correlationData.getId());
		if (ack) {
			log.info(">>>使用MQ消息确认机制确保消息一定要投递到MQ中成功");
			return;
		}
		JSONObject jsonObject = JSONObject.parseObject(jsonString);
		// 生产者消息投递失败的话，采用递归重试机制
		send(jsonObject);
		log.debug(">>>使用MQ消息确认机制投递到MQ中失败");
	}
}
