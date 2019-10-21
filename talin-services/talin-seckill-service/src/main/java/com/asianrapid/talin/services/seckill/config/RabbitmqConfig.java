package com.asianrapid.talin.services.seckill.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 
 * RabbitmqConfig 配置
 *
 * @author Nio
 */
@Component
public class RabbitmqConfig {

	// 添加修改库存队列
	public static final String SECKILL_ORDER_QUEUE = "seckill_order_queue";
	// 交换机名称
	public static final String SECKILL_EXCHANGE_NAME = "seckill_exchange_name";

	/**
	 * 添加交换机队列
	 * @return
	 */
	@Bean
	public Queue directModifyInventoryQueue() {
		return new Queue(SECKILL_ORDER_QUEUE);
	}

	/**
	 * 定义交换机
	 * @return
	 */
	@Bean
	DirectExchange directModifyExchange() {
		return new DirectExchange(SECKILL_EXCHANGE_NAME);
	}

	/**
	 * 修改库存队列绑定交换机
	 * @return
	 */
	@Bean
	Binding bindingExchangeintegralDicQueue() {
		return BindingBuilder.bind(directModifyInventoryQueue()).to(directModifyExchange()).with("seckill");
	}

}
