package com.asianrapid.talin;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.alibaba.sentinel.annotation.SentinelRestTemplate;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName PayApplication
 * @Author Nio
 * @Date 2019/8/30 0030
 * @Version V1.0
 **/

@EnableSwagger2Doc
@SpringBootApplication(scanBasePackages = "com.asianrapid.talin.*")
@EnableFeignClients(basePackages = {"com.asianrapid.talin.api"})
@EnableDistributedTransaction
@EnableTransactionManagement
@EnableDiscoveryClient
@EnableAsync
public class PayApplication {

    public static void main(String[] args) {

        SpringApplication.run(PayApplication.class, args);
    }
    @Bean
    @LoadBalanced
    @SentinelRestTemplate
    RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
