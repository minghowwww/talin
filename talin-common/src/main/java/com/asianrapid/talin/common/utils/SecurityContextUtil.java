package com.asianrapid.talin.common.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ClassName SecurityContextUtil
 * @Author Nio
 * @Date 2019/9/7 0007
 * @Version V1.0
 **/
@Component
public class SecurityContextUtil {

    public static Integer getCurrentUserId() {
        //获取当前登陆用户
        Map<String, Object> currentUser = getCurrentUser();
        return (Integer) currentUser.get("id");
    }

    /**
     * 获取当前登陆用户信息
     * @return
     */
    public static  Map<String, Object> getCurrentUser() {
        //获取当前登陆用户
        OAuth2Authentication authentication = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
        Authentication userAuthentication = authentication.getUserAuthentication();
        Map<String, Object> userAuthenticationMap = (Map<String, Object>) userAuthentication.getDetails();
        return (Map<String, Object>) userAuthenticationMap.get("principal");
    }

}
