package com.asianrapid.talin.common.domain.dbo;

import lombok.Data;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @author Nio
 */
@Data
@Entity
@Table(name = "role")
@Lazy(value = false)
public class Role implements Serializable {

    private static final long serialVersionUID = -378451941834777372L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(name = "role_code")
    private String roleCode;

    @Column(name = "menu_list")
    private String menuList;

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

}
