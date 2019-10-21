package com.asianrapid.talin.services.pay.template.unionpay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.config.AlipayConfig;
import com.asianrapid.talin.common.consts.SystemConst;
import com.asianrapid.talin.common.exception.TalinServiceException;
import com.asianrapid.talin.services.pay.template.AbstractPayCallbackTemplate;
import com.unionpay.acp.sdk.LogUtil;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @ClassName AliPaySyncCallbackTemplate
 * @Description: 支付宝同步回调调转页面
 * @Author Nio
 * @Date 2019/9/7 0007
 * @Version V1.0
 **/
@Component
public class AliPaySyncCallbackTemplate extends AbstractPayCallbackTemplate {

    @Override
    public Map<String, String> verifySignature(HttpServletRequest req, HttpServletResponse resp) {    //获取支付宝POST过来反馈信息
        Map<String, String> params = AliVerifySignature.verifySignature(req);
        // 重要！验证签名前不要修改reqParam中的键值对的内容，否则会验签不过
        try {
            if (!AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type)) {
                LogUtil.writeLog("验证签名结果[失败].");
                params.put(SystemConst.PAY_RESULT_NAME, SystemConst.PAY_RESULT_PAYCODE_201);
            } else {
                LogUtil.writeLog("验证签名结果[成功].");
                params.put(SystemConst.PAY_RESULT_NAME, SystemConst.PAY_RESULT_PAYCODE_200);
            }
        } catch (AlipayApiException e) {
            throw new TalinServiceException("验签异常", e);
        }
        LogUtil.writeLog("接收后台通知结束");
        return params;
    }
    @Override
    public String asyncService(Map<String, String> verifySignature) {
        return successResult();
    }

    @Override
    public String failResult() {
        return "fail";
    }

    @Override
    public String successResult() {
        return "跳转商户页面";
    }
}
