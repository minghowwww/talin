package com.asianrapid.talin.api.client.seckill;

import com.asianrapid.talin.api.failback.SeckillServiceFallback;
import com.asianrapid.talin.common.domain.common.BaseResponse;
import com.asianrapid.talin.common.domain.dto.seckill.RushDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * 秒杀服务抽象接口
 *
 * @author Nio
 */
@FeignClient(value = "app-asianrapid-seckill", fallback = SeckillServiceFallback.class, path = "/seckill")
public interface SeckillServiceApi {

    /**
     * 秒杀抢购接口
     *
     * @param rushDTO 活动id，商品id，用户id
     * @return
     */
    @PutMapping("/rush")
    BaseResponse<String> rush(@Valid RushDTO rushDTO, BindingResult result);

    /**
     * 同步库存到redis
     *
     * @param activityId 秒杀活动id
     * @return
     */
    @PostMapping("/syncStock")
    BaseResponse<String> syncStock(String activityId);
}
