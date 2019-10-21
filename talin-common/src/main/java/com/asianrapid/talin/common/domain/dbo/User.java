package com.asianrapid.talin.common.domain.dbo;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * @author Nio
 */
@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = -7892138758783574625L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String password;

	private String username;

	private String nickname;

	private String email;

	private String phone;

	@Column(name = "is_manager")
	private long isManager;

	@Column(name = "is_deleted")
	private long isDeleted;

	@Column(name = "create_by")
	private long createBy;

	@Column(name = "update_by")
	private long updateBy;

	@Column(name = "create_time")
	private java.util.Date createTime;

	@Column(name = "update_time")
	private java.util.Date updateTime;

}
