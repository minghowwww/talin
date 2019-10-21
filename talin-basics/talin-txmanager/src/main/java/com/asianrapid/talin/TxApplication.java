package com.asianrapid.talin;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName TxApplication
 * @Author Nio
 * @Date 2019/8/20 0020
 * @Version V1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagerServer
public class TxApplication {
    public static void main(String[] args) {
        SpringApplication.run(TxApplication.class, args);
    }
}
