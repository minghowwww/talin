package com.asianrapid.talin.common.domain.dto.pay;

import com.asianrapid.talin.common.consts.SystemConst;
import com.asianrapid.talin.common.domain.common.BasePojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName GetPayDTO
 * @Description: 获取支付令牌dto
 * @Author Nio
 * @Date 2019/8/30 0030
 * @Version V1.0
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("获取支付令牌dto")
public class GetPayDTO extends BasePojo {

    private static final long serialVersionUID = -6556330263568515008L;

    @NotNull(message = "客户id" + SystemConst.PARAM_NOT_NULL)
    @ApiModelProperty(name = "客户id", readOnly = true)
    private Long customerId;

    @NotNull(message = "金额" + SystemConst.PARAM_NOT_NULL)
    @ApiModelProperty(name = "金额", readOnly = true)
    private Long amount;

    @NotNull(message = "订单id" + SystemConst.PARAM_NOT_NULL)
    @NotBlank(message = "订单id" + SystemConst.PARAM_NOT_NULL)
    @ApiModelProperty(name = "订单id", readOnly = true)
    private String orderId;

    @Override
    public String toString() {
        return "GetPayDTO{" +
                "customerId=" + customerId +
                ", amount=" + amount +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
