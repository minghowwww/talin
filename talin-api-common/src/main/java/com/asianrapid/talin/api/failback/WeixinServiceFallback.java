package com.asianrapid.talin.api.failback;

import com.asianrapid.talin.api.client.weixin.WeixinServiceApi;
import com.asianrapid.talin.common.consts.SystemMessageConst;
import com.asianrapid.talin.common.domain.common.BaseResponse;
import com.asianrapid.talin.common.domain.dto.weixin.AppEntity;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @ClassName WeixinServiceFallback
 * @Author Nio
 * @Date 2019/8/17 0017
 * @Version V1.0
 **/
@Slf4j
@Component
public class WeixinServiceFallback implements FallbackFactory<WeixinServiceApi>{
    @Override
    public WeixinServiceApi create(Throwable throwable) {
        return new WeixinServiceApi() {

            @Override
            public BaseResponse<AppEntity> getAppInfo() {
                log.error("weixin.getAppInfo.降级", throwable);
                return BaseResponse.error(SystemMessageConst.SERVICE_FALLBACK, new AppEntity("500", "Weixin.fallback"));
            }

            @Override
            public AppEntity testMember() {
                return new AppEntity("500", "Weixin.fallback");
            }
        };
    }

}
