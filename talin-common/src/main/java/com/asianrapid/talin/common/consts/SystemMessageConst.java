package com.asianrapid.talin.common.consts;

/**
 * @ClassName SystemMessageConst
 * @Description: 异常信息常量类
 * @Author Nio
 * @Date 2019/8/30 0030
 * @Version V1.0
 **/
public class SystemMessageConst extends SystemConst {
    /**
     * 重复支付异常提示
     */
    public static final String PAY_ERROR_REPEAT_MESSAGE = "支付失败（重复支付）";
    /**
     * 支付失败
     */
    public static final String PAY_ERROR_MESSAGE = "支付失败";

    /**
     * 操作成功
     */
    public static final String OPERATION_SUCCESS = "操作成功";

    /**
     * 服务降级
     */
    public static final String SERVICE_FALLBACK = "服务降级";

    /**
     * 服务器繁忙
     */
    public static final String SERVER_BUSY = "服务器繁忙, 请稍后重试";

    /**
     * 当前库存不足
     */
    public static final String INSUFFICIENT_INVENTORY = "当前库存不足";

    /**
     * 重复下单
     */
    public static final String REPEAT_PURCHASE = "您已经购买过该商品";

    /**
     * 秒杀成功
     */
    public static final String SECKILL_SUCCESS = "秒杀成功";
}
