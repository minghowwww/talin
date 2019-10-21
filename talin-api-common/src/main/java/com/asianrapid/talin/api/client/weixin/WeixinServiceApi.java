package com.asianrapid.talin.api.client.weixin;

import com.asianrapid.talin.api.failback.WeixinServiceFallback;
import com.asianrapid.talin.common.domain.common.BaseResponse;
import com.asianrapid.talin.common.domain.dto.weixin.AppEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "app-asianrapid-weixin", fallbackFactory = WeixinServiceFallback.class, path = "/weixin", decode404 = true)
public interface WeixinServiceApi {

    @PostMapping("/getAppInfo")
    BaseResponse<AppEntity> getAppInfo();

    @GetMapping("/testMember")
    AppEntity testMember();
}
