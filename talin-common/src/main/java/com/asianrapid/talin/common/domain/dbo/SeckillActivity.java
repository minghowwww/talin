package com.asianrapid.talin.common.domain.dbo;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "seckill_activity")
public class SeckillActivity  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "activity_id")
	private long activityId;

	@Column(name = "start_time")
	private java.util.Date startTime;

	@Column(name = "end_time")
	private java.util.Date endTime;

	private long status;

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
