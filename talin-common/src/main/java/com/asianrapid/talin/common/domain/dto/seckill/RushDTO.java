package com.asianrapid.talin.common.domain.dto.seckill;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @ClassName RushDTO
 * @Description: 用户执行抢购操作时传递的参数
 * @Author Nio
 * @Date 2019/9/13 0013
 * @Version V1.0
 **/
@ApiModel("秒杀抢购参数dto")
@Data
public class RushDTO {

    /**
     * 抢购活动id
     */
    @ApiModelProperty("秒杀活动id")
    @NotEmpty(message = "活动id不能为空")
    private String activityId;
    /**
     * 抢购商品id
     */
    @ApiModelProperty("秒杀商品id")
    @NotEmpty(message = "商品id不能为空")
    private String itemId;
    /**
     * 抢购用户id
     */
    @ApiModelProperty("秒杀用户id")
    @NotNull(message = "用户id不能为空")
    private Long userId;
}
