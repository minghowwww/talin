package com.asianrapid.talin.common.helper;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Locale;

@Slf4j
@Component
public class MessageSourceHelper implements Serializable {

    private static final long serialVersionUID = 6331629858450840170L;

    @Autowired
    private MessageSource messageSource;

    public String getMessage(String pattern, Object[] arguments) {
        log.debug("获取资源，pattern:" + pattern + "，arguments：" + arguments);
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(pattern, arguments, locale);
    }

    public String getMessage(String pattern) {
        log.debug("获取资源，pattern:" + pattern);
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(pattern, null, locale);
    }
}
