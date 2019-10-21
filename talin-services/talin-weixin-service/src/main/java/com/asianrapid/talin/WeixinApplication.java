package com.asianrapid.talin;

import com.asianrapid.talin.common.config.RequestAttributeHystrixConcurrencyStrategy;
import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.alibaba.sentinel.annotation.SentinelRestTemplate;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextListener;

/**
 * @author Nio
 */

@EnableSwagger2Doc
@SpringBootApplication(scanBasePackages = "com.asianrapid.talin.*")
@EnableFeignClients(basePackages = {"com.asianrapid.talin.api"})
@EnableDistributedTransaction
@EnableTransactionManagement
@EnableDiscoveryClient
public class WeixinApplication {
    public static void main(String[] args) {

        SpringApplication.run(WeixinApplication.class, args);
    }

    @Bean
    @LoadBalanced
    @SentinelRestTemplate
    RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

    @Bean
    public RequestAttributeHystrixConcurrencyStrategy hystrixRequestAutoConfiguration() {
        return new RequestAttributeHystrixConcurrencyStrategy();
    }
}
