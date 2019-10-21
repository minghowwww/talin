package com.asianrapid.talin.services.pay.controller;

import com.asianrapid.talin.common.controller.BaseController;
import com.asianrapid.talin.common.domain.common.BaseResponse;
import com.asianrapid.talin.common.domain.dto.pay.GetPayDTO;
import com.asianrapid.talin.common.domain.dto.pay.PaymentTransactionDTO;
import com.asianrapid.talin.common.enums.ResponseCodeEnum;
import com.asianrapid.talin.common.exception.TalinServiceException;
import com.asianrapid.talin.common.exception.TalinValidateException;
import com.asianrapid.talin.services.pay.service.PayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @ClassName PayController
 * @Description: 支付服务控制器
 * @Author Nio
 * @Date 2019/8/30 0030
 * @Version V1.0
 **/
@Api(tags = "支付服务接口")
@RequestMapping("/pay")
@RestController
public class PayController extends BaseController {

    private static final long serialVersionUID = -6814444555418693823L;

    private final PayService payService;

    @Autowired
    public PayController(PayService payService) {
        this.payService = payService;
    }

    /**
     * 创建支付token
     *
     * @param getPayDTO
     * @param result
     * @return
     */
    @ApiOperation(value = "获取支付token", notes = "获取支付token")
    @GetMapping("/getPayToken")
    public BaseResponse<String> getPayToken(@Valid GetPayDTO getPayDTO, BindingResult result) {
        try {
            if (result.hasErrors()) {
                return BaseResponse.validateError("getPayDTO参数不符合要求:{}", getPayDTO.toString());
            }
            return payService.getPayToken(getPayDTO);
        } catch (Exception e) {
            throw new TalinServiceException("获取支付令牌失败", e);
        }
    }

    /**
     * 根据token查询支付详细
     *
     * @param token
     * @return
     */
    @ApiOperation(value = "获取支付详情", notes = "根据支付token获取支付详情")
    @GetMapping("/getPayTransactionDetailByToken")
    public BaseResponse<PaymentTransactionDTO> getPayTransactionDetailByToken(String token) {
        try {
            if (StringUtils.isEmpty(token)) {
                return BaseResponse.validateError("token不能为空");
            }
            return payService.getPayTransactionDetailByToken(token);
        } catch (Exception e) {
            throw new TalinServiceException("获取支付详情失败", e);
        }
    }

    /**
     * 获取第三方支付页面（包含报文）
     *
     * @param token
     * @param channelId
     * @return
     */
    @ApiOperation(value = "获取支付第三方支付表单html", notes = "获取支付第三方支付表单html")
    @GetMapping("/getPayHtml")
    public BaseResponse<String> getPayHtml(@RequestParam String token, @RequestParam String channelId) {
        try {
            if (!StringUtils.isEmpty(token) && !StringUtils.isEmpty(channelId)) {

                String payHtml = payService.getPayHtml(token, channelId);
                return BaseResponse.ok(payHtml);
            } else {
                return BaseResponse.validateError("参数不符合要求");
            }
        } catch (TalinValidateException e) {
            throw new TalinServiceException(ResponseCodeEnum.ERROR, "获取支付页面信息失败");
        }
    }

}
