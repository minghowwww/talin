package com.asianrapid.talin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName VestibuleApplication
 * @Author Nio
 * @Date 2019/10/15 0015
 * @Version V1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class VestibuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(VestibuleApplication.class, args);
    }
}
