package com.asianrapid.talin.common.domain;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "integral")
public class Integral  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@Column(name = "USER_ID")
	private long userId;

	@Column(name = "PAYMENT_ID")
	private String paymentId;

	@Column(name = "INTEGRAL")
	private String integral;

	@Column(name = "AVAILABILITY")
	private long availability;

	@Column(name = "REVISION")
	private long revision;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "CREATED_TIME")
	private java.util.Date createdTime;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Column(name = "UPDATED_TIME")
	private java.util.Date updatedTime;


}
