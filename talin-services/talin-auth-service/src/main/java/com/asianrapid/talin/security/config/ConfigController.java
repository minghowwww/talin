package com.asianrapid.talin.security.config;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nio
 * @Description: nacos测试接口
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {
    @Value("${swagger.title}")
    private String useLocalCache;

    @SentinelResource
    @RequestMapping("/get")
    public String get() {
        return useLocalCache;
    }
}