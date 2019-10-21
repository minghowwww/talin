package com.asianrapid.talin.common.domain.dto.user;

import com.asianrapid.talin.common.domain.common.CommonGridCondition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName UserListDTO
 * @Author Nio
 * @Date 2019/9/21 0021
 * @Version V1.0
 **/
@Data
@ApiModel("用户列表查询参数实体")
public class UserListDTO extends CommonGridCondition implements Serializable {
    private static final long serialVersionUID = -8631821796761568007L;

    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @Override
    public String toString() {
        return "UserListDTO{" +
                "username='" + username + '\'' +
                "page='" + getPage() + '\'' +
                "size='" + getSize() + '\'' +
                '}';
    }
}
