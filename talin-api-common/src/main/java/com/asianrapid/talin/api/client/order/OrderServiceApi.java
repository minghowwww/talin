package com.asianrapid.talin.api.client.order;

import com.asianrapid.talin.api.failback.OrderServiceFallback;
import com.asianrapid.talin.common.domain.common.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "app-asianrapid-order", path = "/order", fallbackFactory = OrderServiceFallback.class)
public interface OrderServiceApi {

    @PostMapping("insert")
    BaseResponse insertOrder();
}
