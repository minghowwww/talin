package com.asianrapid.talin.common.domain.dbo;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@Entity
@Table(name = "sys_menu")
public class SysMenu  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long menuId;

	@Column(name = "menu_name")
	private String menuName;

	private String url;

	private String description;

	@Column(name = "parent_menu_id")
	private long parentMenuId;

	@Column(name = "menu_rank")
	private long menuRank;

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

	@Transient
	private List<SysMenu> children;
}
