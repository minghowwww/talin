package com.asianrapid.talin.services.pay.template.unionpay;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.config.AlipayConfig;
import com.asianrapid.talin.common.consts.SystemConst;
import com.asianrapid.talin.common.domain.dbo.PaymentTransaction;
import com.asianrapid.talin.common.exception.TalinServiceException;
import com.asianrapid.talin.services.pay.dao.PaymentTransactionDao;
import com.asianrapid.talin.services.pay.producer.IntegralProducer;
import com.asianrapid.talin.services.pay.template.AbstractPayCallbackTemplate;
import com.unionpay.acp.sdk.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

/**
 * @ClassName AliPayCallbackTemplate
 * @Author Nio
 * @Date 2019/9/6 0006
 * @Version V1.0
 **/
@Component
public class AliPayCallbackTemplate extends AbstractPayCallbackTemplate {

    private final PaymentTransactionDao paymentTransactionDao;
    private final IntegralProducer integralProducer;

    @Autowired
    public AliPayCallbackTemplate(PaymentTransactionDao paymentTransactionDao, IntegralProducer integralProducer) {
        this.paymentTransactionDao = paymentTransactionDao;
        this.integralProducer = integralProducer;
    }

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
                // 【注：为了安全验签成功才应该写商户的成功处理逻辑】交易成功，更新商户订单状态
                // 获取后台通知的数据，其他字段也可用类似方式获取
                String orderId = new String(req.getParameter("out_trade_no").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
                String tradeStatus = new String(req.getParameter("trade_status").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
                params.put("tradeStatus", tradeStatus);
                params.put("paymentId", orderId);
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
        String tradeStatus = "tradeStatus";
        if (verifySignature.get(tradeStatus).equals(SystemConst.PAY_ALI_TRADE_FINISHED)) {
            //判断该笔订单是否在商户网站中已经做过处理
            //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
            //如果有做过处理，不执行商户的业务程序

            //注意：
            //退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
        } else if (verifySignature.get(tradeStatus).equals(SystemConst.PAY_ALI_TRADE_SUCCESS)) {
            //判断该笔订单是否在商户网站中已经做过处理
            //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
            //如果有做过处理，不执行商户的业务程序

            //注意：
            //付款完成后，支付宝系统发送该交易状态通知
            PaymentTransaction paymentTransaction = paymentTransactionDao.findByPaymentId(verifySignature.get("paymentId"));
            if (paymentTransaction.getPaymentStatus().equals(SystemConst.PAY_STATUS_SUCCESS)) {
                // 网络重试中，之前已经支付过
                return successResult();
            }
            // 2.将状态改为已经支付成功
            paymentTransaction.setPaymentStatus(SystemConst.PAY_STATUS_SUCCESS);
            paymentTransaction.setUpdatedTime(new Date());
            paymentTransaction.setUpdatedBy(SystemConst.THIRD_PARTY_PAYMENT_USER_ID);
            paymentTransactionDao.saveAndFlush(paymentTransaction);
            addMQIntegral(paymentTransaction);
        }

        return successResult();

    }

    @Async
    protected void addMQIntegral(PaymentTransaction paymentTransaction) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("paymentId", paymentTransaction.getPaymentId());
        jsonObject.put("userId", paymentTransaction.getUserId());
        jsonObject.put("integral", 100);
        integralProducer.send(jsonObject);
    }

    @Override
    public String failResult() {
        return SystemConst.PAY_ALI_RESULT_FAIL;
    }

    @Override
    public String successResult() {
        return SystemConst.PAY_ALI_RESULT_SUCCESS;
    }
}
