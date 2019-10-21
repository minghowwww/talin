package com.asianrapid.talin;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ItemApplication
 * @Description: 商品服务
 * @Author Nio
 * @Date 2019/9/17 0017
 * @Version V1.0
 **/

@EnableSwagger2Doc
@SpringBootApplication(scanBasePackages = "com.asianrapid.talin.*")
@EnableFeignClients(basePackages = {"com.asianrapid.talin.api"})
@EnableDistributedTransaction
@EnableTransactionManagement
@EnableDiscoveryClient
public class ItemApplication {

    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(ItemApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
