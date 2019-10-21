package com.asianrapid.talin.common.domain.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName CommonGridCondition
 * @Description: 列表查询基础参数实体
 * @Author Nio
 * @Date 2019/9/21 0021
 * @Version V1.0
 **/
@ApiModel("列表查询基础参数实体")
@Data
public class CommonGridCondition implements Serializable {
    private static final long serialVersionUID = 328565501763881871L;

    @ApiModelProperty(value = "当前页数", required = true)
    @NotNull(message = "page不能为空")
    private Integer page;
    @ApiModelProperty(value = "当前页数", required = true)
    @NotNull(message = "page不能为空")
    private Integer size;
}
