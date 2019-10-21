package com.asianrapid.talin.api.failback;

import com.asianrapid.talin.api.client.pay.PayServiceApi;
import com.asianrapid.talin.common.consts.SystemMessageConst;
import com.asianrapid.talin.common.controller.BaseController;
import com.asianrapid.talin.common.domain.common.BaseResponse;
import com.asianrapid.talin.common.domain.dmo.PayChannelDMO;
import com.asianrapid.talin.common.domain.dto.pay.GetPayDTO;
import com.asianrapid.talin.common.domain.dto.pay.PaymentTransactionDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName PayServiceFallback
 * @Description: 支付服务降级
 * @Author Nio
 * @Date 2019/8/30 0030
 * @Version V1.0
 **/
@Component
public class PayServiceFallback extends BaseController implements PayServiceApi {
    private static final long serialVersionUID = -2955366551993468400L;

    @Override
    public BaseResponse<String> getPayToken(@Valid GetPayDTO getPayDTO, BindingResult result) {
        return BaseResponse.error(SystemMessageConst.SERVICE_FALLBACK, null);
    }

    @Override
    public BaseResponse<PaymentTransactionDTO> getPayTransactionDetailByToken(String token) {
        return BaseResponse.error(SystemMessageConst.SERVICE_FALLBACK, null);
    }

    @Override
    public BaseResponse<List<PayChannelDMO>> listPayChannels() {
        return BaseResponse.error(SystemMessageConst.SERVICE_FALLBACK, null);
    }

    @Override
    public BaseResponse<String> getPayHtml(@RequestParam String token, @RequestParam String channelId) {
        return BaseResponse.error(SystemMessageConst.SERVICE_FALLBACK, null);
    }
}
