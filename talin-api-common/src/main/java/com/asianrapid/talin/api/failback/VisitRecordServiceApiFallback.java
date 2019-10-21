package com.asianrapid.talin.api.failback;

import com.alibaba.fastjson.JSONObject;
import com.asianrapid.talin.api.client.member.VisitRecordServiceApi;
import com.asianrapid.talin.common.consts.SystemConst;
import com.asianrapid.talin.common.domain.common.BaseResponse;
import com.asianrapid.talin.common.enums.ResponseCodeEnum;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName VisitRecordServiceApiFallback
 * @Author Nio
 * @Date 2019/8/21 0021
 * @Version V1.0
 **/
@Component
public class VisitRecordServiceApiFallback implements FallbackFactory<VisitRecordServiceApi> {
    @Override
    public VisitRecordServiceApi create(Throwable throwable) {
        return new VisitRecordServiceApi() {
            @Override
            public BaseResponse insertVisitRecord() {
                return null;
            }
        };
    }


}
