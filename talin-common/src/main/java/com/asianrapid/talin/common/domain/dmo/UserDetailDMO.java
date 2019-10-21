package com.asianrapid.talin.common.domain.dmo;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName UserDetailDMO
 * @Description: 用户详细信息model
 * @Author Nio
 * @Date 2019/9/23 0023
 * @Version V1.0
 **/
@Data
public class UserDetailDMO implements Serializable {

    private static final long serialVersionUID = -7000756580360577704L;

    private String username;
    private String password;
    private String email;
    private String phone;
    private Long isManager;
}
