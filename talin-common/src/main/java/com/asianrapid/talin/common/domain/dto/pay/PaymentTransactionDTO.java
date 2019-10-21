package com.asianrapid.talin.common.domain.dto.pay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName PaymentTransactionDTO
 * @Description: 支付详情DTO
 * @Author Nio
 * @Date 2019/8/30 0030
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentTransactionDTO implements Serializable {

    private static final long serialVersionUID = -7554080348641395579L;
    /** 主键ID */
//    private Long id;
    /** 支付金额 */
    private Long payAmount;
    /** 支付状态;0待支付1支付完成 2支付超时3支付失败 */
    private Integer paymentStatus;
    /** 用户ID */
//    private Long userId;
    /** 订单号码 */
    private String orderId;

    /** 创建时间 */
    private Date createdTime;

    /**
     * 第三方支付id 支付宝、银联等
     */
    private String partyPayId;

    /**
     * 使用雪花算法生产 支付系统 支付id
     */
    private String paymentId;

}
