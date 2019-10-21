package com.asianrapid.talin.services.pay.factory;

import com.asianrapid.talin.services.pay.strategy.PayStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class StrategyFactory {
	private static Map<String, PayStrategy> strategyBean = new ConcurrentHashMap<String, PayStrategy>();

	// 思考几个点：
	public static PayStrategy getPayStrategy(String classAddres) {
		try {
			if (StringUtils.isEmpty(classAddres)) {
				return null;
			}
			PayStrategy beanPayStrategy = strategyBean.get(classAddres);
			if (beanPayStrategy != null) {
				return beanPayStrategy;
			}
			// 1.使用Java的反射机制初始化子类
			Class<?> forName = Class.forName(classAddres);
			// 2.反射机制初始化对象
			PayStrategy payStrategy = (PayStrategy) forName.newInstance();
			strategyBean.put(classAddres, payStrategy);
			return payStrategy;
		} catch (Exception e) {
			log.error("获取支付渠道实例实例失败", e);
			return null;
		}

	}

}
