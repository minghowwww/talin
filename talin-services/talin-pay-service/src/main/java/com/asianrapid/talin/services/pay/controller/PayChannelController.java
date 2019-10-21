package com.asianrapid.talin.services.pay.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.asianrapid.talin.common.controller.BaseController;
import com.asianrapid.talin.common.domain.PaymentChannel;
import com.asianrapid.talin.common.domain.common.BaseResponse;
import com.asianrapid.talin.common.domain.dmo.PayChannelDMO;
import com.asianrapid.talin.services.pay.service.PayChannelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PayChannelController
 * @Description: 支付服务-支付渠道控制器
 * @Author Nio
 * @Date 2019/8/31 0031
 * @Version V1.0
 **/
@Api(tags = "支付渠道服务接口")
@RequestMapping("pay")
@RestController
public class PayChannelController extends BaseController {

    private static final long serialVersionUID = -7677311646565973697L;
    private final PayChannelService payChannelService;

    @Autowired
    public PayChannelController(PayChannelService payChannelService) {
        this.payChannelService = payChannelService;
    }

    @SentinelResource(value = "listPayChannels", fallback = "fallbackHandler", blockHandler = "exceptionHandler")
    @ApiOperation(value = "查询所有支付渠道信息", notes = "查询所有支付渠道信息")
    @GetMapping("/listPayChannels")
    public BaseResponse<List<PayChannelDMO>> listPayChannels() throws InterruptedException {

//        Thread.sleep(5000);

        List<PaymentChannel> listPayChannels = payChannelService.listPayChannels();
        List<PayChannelDMO> result = new ArrayList<>();
        listPayChannels.forEach(v -> {
            PayChannelDMO payChannelDMO = new PayChannelDMO(v.getChannelName(), v.getMerchantId(), v.getSyncUrl(), v.getAsynUrl(), v.getPublicKey(), v.getPrivateKey());
            result.add(payChannelDMO);
        });
//        return BaseResponse.ok(result);
        throw new RuntimeException();
    }


    public BaseResponse<List<PayChannelDMO>> fallbackHandler() {
        return null;
    }


    public BaseResponse<List<PayChannelDMO>> exceptionHandler(BlockException e) {
        errorLog(e.getMessage());
        return null;
    }
}
