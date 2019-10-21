package com.asianrapid.talin.common.domain.dbo;

import com.asianrapid.talin.common.domain.dbo.primaryKey.UserRolePK;
import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @author Nio
 */
@Data
@Entity
@Table(name = "user_role")
@Lazy(value = false)
public class UserRole implements Serializable , GrantedAuthority {

    private static final long serialVersionUID = 5158161538166355147L;

    @EmbeddedId
    private UserRolePK id;

    @Column(name = "is_deleted")
    private long isDeleted;

    @Column(name = "update_by")
    private long updateBy;

    @Column(name = "create_by")
    private long createBy;

    @Column(name = "update_time")
    private java.util.Date updateTime;

    @Column(name = "create_time")
    private java.util.Date createTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    private Role roleId;

    @Override
    public String getAuthority() {
        return this.roleId.getRoleCode();
    }
}
