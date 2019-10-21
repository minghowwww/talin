package com.asianrapid.talin.services.pay.strategy;

import com.asianrapid.talin.common.domain.PaymentChannel;
import com.asianrapid.talin.common.domain.dto.pay.PaymentTransactionDTO;

/**
 * @ClassName PayStrategy
 * @Description: 支付渠道抽象策略
 * @Author Nio
 * @Date 2019/9/2 0002
 * @Version V1.0
 **/
public interface PayStrategy {

    /**
     * 根据渠道信息和交易信息组装支付报文，并返回支付页面信息
     * @param paymentChannel
     * @param paymentTransactionDTO
     * @return
     */
    String getPayHtml(PaymentChannel paymentChannel, PaymentTransactionDTO paymentTransactionDTO);
}
