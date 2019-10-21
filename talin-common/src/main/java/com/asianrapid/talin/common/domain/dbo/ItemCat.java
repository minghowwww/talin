package com.asianrapid.talin.common.domain.dbo;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "item_cat")
public class ItemCat  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name = "parent_id")
	private long parentId;

	private String name;

	private long status;

	@Column(name = "sort_order")
	private long sortOrder;

	@Column(name = "is_parent")
	private long isParent;

	@Column(name = "is_deleted")
	private long isDeleted;

	@Column(name = "CREATED_TIME")
	private java.util.Date createdTime;

	@Column(name = "UPDATED_TIME")
	private java.util.Date updatedTime;

	@Column(name = "CREATED_BY")
	private long createdBy;

	@Column(name = "UPDATED_BY")
	private long updatedBy;
}
