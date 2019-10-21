package com.asianrapid.talin.api.client.pay;

import com.asianrapid.talin.api.failback.PayServiceFallback;
import com.asianrapid.talin.common.domain.common.BaseResponse;
import com.asianrapid.talin.common.domain.dmo.PayChannelDMO;
import com.asianrapid.talin.common.domain.dto.pay.GetPayDTO;
import com.asianrapid.talin.common.domain.dto.pay.PaymentTransactionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@FeignClient(value = "app-asianrapid-pay", fallback = PayServiceFallback.class, path = "/pay")
public interface PayServiceApi {

    /**
     * 获取支付令牌
     * @param getPayDTO
     * @param result
     * @return 支付令牌
     */
    @GetMapping("/getPayToken")
    BaseResponse<String> getPayToken(@RequestParam @Valid GetPayDTO getPayDTO, BindingResult result);

    /**
     * 根据支付令牌获取支付信息详情
     * @param token
     * @return 支付内容详情
     */
    @GetMapping("/getPayTransactionDetailByToken")
    BaseResponse<PaymentTransactionDTO> getPayTransactionDetailByToken(String token);

    /**
     * 查询所有的支付渠道
     * @return
     */
    @GetMapping("/listPayChannels")
    BaseResponse<List<PayChannelDMO>> listPayChannels();

    /**
     * 获取第三方支付页面（包含报文）
     * @param token
     * @param channelId
     * @return
     */
    @GetMapping("/getPayHtml")
    BaseResponse<String> getPayHtml(@RequestParam String token, @RequestParam String channelId);
}
