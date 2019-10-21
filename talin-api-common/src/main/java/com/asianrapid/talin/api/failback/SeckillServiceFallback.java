package com.asianrapid.talin.api.failback;

import com.asianrapid.talin.api.client.seckill.SeckillServiceApi;
import com.asianrapid.talin.common.consts.SystemMessageConst;
import com.asianrapid.talin.common.domain.common.BaseResponse;
import com.asianrapid.talin.common.domain.dto.seckill.RushDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;

/**
 * @ClassName SeckillServiceFallback
 * @Description: 秒杀服务降级
 * @Author Nio
 * @Date 2019/9/13 0013
 * @Version V1.0
 **/
@Component
public class SeckillServiceFallback implements SeckillServiceApi {
    @Override
    public BaseResponse<String> rush(@Valid RushDTO rushDTO, BindingResult result) {
        return BaseResponse.error(SystemMessageConst.SERVER_BUSY, null);
    }

    @Override
    public BaseResponse<String> syncStock(String activityId) {
        return BaseResponse.error(SystemMessageConst.SERVICE_FALLBACK, null);
    }
}
