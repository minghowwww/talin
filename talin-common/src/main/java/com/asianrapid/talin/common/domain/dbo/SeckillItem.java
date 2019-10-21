package com.asianrapid.talin.common.domain.dbo;
import com.asianrapid.talin.common.domain.dbo.primaryKey.SeckillItemPK;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "seckill_item")
@IdClass(SeckillItemPK.class)
public class SeckillItem  implements Serializable {
	@Id
	@Column(name = "item_id")
	private long itemId;
	@Id
	@Column(name = "activity_id")
	private long activityId;

	private String title;

	@Column(name = "sell_point")
	private String sellPoint;

	private long price;

	private long number;

	private String barcode;

	private String image;

	private String cid;

	private String status;

	private String description;

	@Column(name = "REVISION")
	private long revision;

	@Column(name = "CREATED_BY")
	private long createdBy;

	@Column(name = "CREATED_TIME")
	private java.util.Date createdTime;

	@Column(name = "UPDATED_BY")
	private long updatedBy;

	@Column(name = "UPDATED_TIME")
	private java.util.Date updatedTime;


}
