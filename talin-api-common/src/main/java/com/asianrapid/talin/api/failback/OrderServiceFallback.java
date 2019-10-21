package com.asianrapid.talin.api.failback;

import com.alibaba.fastjson.JSONObject;
import com.asianrapid.talin.api.client.order.OrderServiceApi;
import com.asianrapid.talin.common.consts.SystemConst;
import com.asianrapid.talin.common.consts.SystemMessageConst;
import com.asianrapid.talin.common.domain.common.BaseResponse;
import com.asianrapid.talin.common.enums.ResponseCodeEnum;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @ClassName OrderServiceFallback
 * @Description: TODO
 * @Author Nio
 * @Date 2019/8/24 0024
 * @Version V1.0
 **/
@Slf4j
@Component
public class OrderServiceFallback implements FallbackFactory<OrderServiceApi> {
    @Override
    public OrderServiceApi create(Throwable throwable) {
        return new OrderServiceApi() {
            @Override
            public BaseResponse insertOrder() {
                log.error("新增订单失败", throwable);
                JSONObject response = new JSONObject();
                response.put(SystemConst.RESPONSE_CODE_KEY, ResponseCodeEnum.ERROR);
                response.put(SystemConst.RESPONSE_DATA_KEY, "新增订单失败");
                return BaseResponse.error(SystemMessageConst.SERVICE_FALLBACK);
            }
        };
    }
}
