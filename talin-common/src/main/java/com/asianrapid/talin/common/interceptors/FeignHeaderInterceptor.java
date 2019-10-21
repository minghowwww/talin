package com.asianrapid.talin.common.interceptors;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * feign调用携带token
 */
@Component
public class FeignHeaderInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
//        template.header(HttpHeaders.AUTHORIZATION, "token");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //添加token
        String token = null;
        if (request.getHeader("Authorization") != null) {
            String authorization = request.getHeader("Authorization");
//            authorization = authorization.substring(authorization.indexOf(" "));
            token = authorization.trim();
        } else {
            String header = request.getHeader("access-token");
            token = header;
        }
        template.header("Authorization", token);
    }
}