package com.asianrapid.talin.services.seckill.controller;

import com.asianrapid.talin.api.client.seckill.SeckillServiceApi;
import com.asianrapid.talin.common.domain.common.BaseResponse;
import com.asianrapid.talin.common.domain.dto.seckill.RushDTO;
import com.asianrapid.talin.common.exception.TalinServiceException;
import com.asianrapid.talin.services.seckill.service.SeckillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @ClassName SeckillController
 * @Description: 秒杀服务控制器
 * @Author Nio
 * @Date 2019/9/13 0013
 * @Version V1.0
 **/
@Api(tags = "秒杀服务接口")
@RestController
public class SeckillController implements SeckillServiceApi {

    private final SeckillService seckillService;

    @Autowired
    public SeckillController(SeckillService seckillService) {
        this.seckillService = seckillService;
    }

    @ApiOperation(value = "秒杀接口", notes = "秒杀接口")
    @Override
    public BaseResponse<String> rush(@Valid RushDTO rushDTO, BindingResult result) {
        try {
            if (result.hasErrors()) {
                return BaseResponse.error(result.getFieldError().getDefaultMessage());
            }
            return seckillService.rush(rushDTO);
        } catch (Exception e) {
            throw new TalinServiceException("抢购失败", e);
        }
    }

    @Override
    public BaseResponse<String> syncStock(String activityId) {
        try {
            if (StringUtils.isEmpty(activityId)) {
                return BaseResponse.error("activityId不能为空");
            }
            return seckillService.syncStock(activityId);
        } catch (Exception e) {
            throw new TalinServiceException("同步库存失败", e);
        }
    }
}
