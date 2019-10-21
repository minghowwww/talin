package com.asianrapid.talin.api.client.member;

import com.asianrapid.talin.api.failback.VisitRecordServiceApiFallback;
import com.asianrapid.talin.common.domain.common.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "app-asianrapid-visitRecord", fallbackFactory = VisitRecordServiceApiFallback.class, path = "/visitRecord")
public interface VisitRecordServiceApi {

    @PostMapping("/insert")
    BaseResponse insertVisitRecord();
}
