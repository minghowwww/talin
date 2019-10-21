package com.asianrapid.talin.api.client.member;

import com.asianrapid.talin.api.failback.MemberServiceFallback;
import com.asianrapid.talin.common.domain.common.BaseResponse;
import com.asianrapid.talin.common.domain.dto.weixin.AppEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "app-asianrapid-member", fallback = MemberServiceFallback.class, path = "/member")
public interface MemberServiceApi {

    @PostMapping("/memberToWeixin")
    BaseResponse<AppEntity> getAppInfo();

    @GetMapping("/test")
    AppEntity test();

    @PostMapping("/insertCustomer")
    BaseResponse insertCustomer();
}
