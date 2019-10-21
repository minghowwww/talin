package com.asianrapid.talin.common.domain.dbo.primaryKey;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @ClassName UserRolePK
 * @Author Nio
 * @Date 2019/9/18 0018
 * @Version V1.0
 **/
@Data
@Embeddable
public class UserRolePK implements Serializable {

    private static final long serialVersionUID = -1111130862592324184L;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "role_id")
    private long roleId;

}
