package com.asianrapid.talin.common.domain.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName RegistDTO
 * @Description: 用户注册参数对象
 * @Author Nio
 * @Date 2019/9/18 0018
 * @Version V1.0
 **/
@ApiModel("用户注册参数对象")
@Data
public class RegistDTO implements Serializable {
    private static final long serialVersionUID = -5579745914753790327L;


    @ApiModelProperty(required = true, notes = "username不能为空", name = "用户名")
    @NotNull(message = "username不能为空")
    private String username;
    @ApiModelProperty(required = true, notes = "password不能为空", name = "密码")
    @NotNull(message = "password不能为空")
    private String password;
    @ApiModelProperty(required = true, notes = "email不能为空", name = "邮箱")
    @NotNull(message = "email不能为空")
    private String email;
    @ApiModelProperty(required = true, notes = "phone不能为空", name = "手机号码")
    @NotNull(message = "phone不能为空")
    private String phone;

    @ApiModelProperty(name = "是否为系统用户")
    private Integer isManager;
}
