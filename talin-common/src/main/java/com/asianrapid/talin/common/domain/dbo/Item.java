package com.asianrapid.talin.common.domain.dbo;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "item")
public class Item  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String title;

	@Column(name = "sell_point")
	private String sellPoint;

	private long price;

	private long num;

	private String barcode;

	private String image;

	private long cid;

	private long status;

	@Column(name = "REVISION")
	private long revision;

	@Column(name = "CREATED_TIME")
	private java.util.Date createdTime;

	@Column(name = "UPDATED_TIME")
	private java.util.Date updatedTime;

	@Column(name = "CREATED_BY")
	private long createdBy;

	@Column(name = "UPDATED_BY")
	private long updatedBy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cid", insertable = false, updatable = false)
	private ItemCat itemCat;
}
