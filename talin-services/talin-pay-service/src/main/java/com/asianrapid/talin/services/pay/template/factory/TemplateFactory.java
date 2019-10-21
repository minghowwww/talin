package com.asianrapid.talin.services.pay.template.factory;

import com.asianrapid.talin.common.utils.SpringContextUtil;
import com.asianrapid.talin.services.pay.template.AbstractPayCallbackTemplate;

/**
 * @author Nio
 */
public class TemplateFactory {

	public static AbstractPayCallbackTemplate getPayCallbackTemplate(String beanId) {
		return (AbstractPayCallbackTemplate) SpringContextUtil.getBean(beanId);
	}

}
