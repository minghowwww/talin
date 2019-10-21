package com.asianrapid.talin.services.pay.init;

import com.unionpay.acp.sdk.SDKConfig;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @ClassName InitUnionPay
 * @Description: 初始化加载银联证书
 * @Author Nio
 * @Date 2019/9/4 0004
 * @Version V1.0
 **/
@Component
public class InitUnionPay implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {

		SDKConfig.getConfig().loadPropertiesFromSrc();
    }
}
