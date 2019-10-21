package com.asianrapid.talin;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName AuthApplication
 * @Author Nio
 * @Date 2019/8/7 0007
 * @Version V1.0
 **/
//@EnableEurekaClient
@EnableSwagger2Doc
//@EnableApolloConfig
@EnableDistributedTransaction
@EnableTransactionManagement
@EntityScan(basePackages = "com.asianrapid.talin.common.domain")
@EnableFeignClients(basePackages = {"com.asianrapid.talin.api"})
@SpringBootApplication(scanBasePackages = "com.asianrapid.talin.*")
@EnableDiscoveryClient
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
