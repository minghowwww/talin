package com.asianrapid.talin.services.pay.config;

import com.asianrapid.talin.common.consts.SystemConst;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author Nio
 */
@Component
public class RabbitmqConfig {

	/**
	 * 添加积分队列
	 * @return
	 */
	@Bean
	public Queue directIntegralDicQueue() {
		return new Queue(SystemConst.INTEGRAL_DIC_QUEUE);
	}

	/**
	 * 定义支付补偿队列
	 * @return
	 */
	@Bean
	public Queue directCreateintegralQueue() {
		return new Queue(SystemConst.PAYMENT_COMPENSATE_QUEUE);
	}

	/**
	 * 定义交换机
	 * @return
	 */
	@Bean
	DirectExchange directintegralExchange() {
		return new DirectExchange(SystemConst.INTEGRAL_EXCHANGE_NAME);
	}

	/**
	 * 积分队列与交换机绑定
	 * @return
	 */
	@Bean
	Binding bindingExchangeintegralDicQueue() {
		return BindingBuilder.bind(directIntegralDicQueue()).to(directintegralExchange()).with("integralRoutingKey");
	}

	/**
	 * 补偿队列与交换机绑定
	 * @return
	 */
	@Bean
	Binding bindingExchangeCreateintegral() {
		return BindingBuilder.bind(directCreateintegralQueue()).to(directintegralExchange()).with("integralRoutingKey");
	}

}
