package com.asianrapid.talin.common.domain;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "payment_channel")
public class PaymentChannel  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@Column(name = "CHANNEL_NAME")
	private String channelName;

	@Column(name = "CHANNEL_ID")
	private String channelId;

	@Column(name = "MERCHANT_ID")
	private String merchantId;

	@Column(name = "SYNC_URL")
	private String syncUrl;

	@Column(name = "ASYN_URL")
	private String asynUrl;

	@Column(name = "PUBLIC_KEY")
	private String publicKey;

	@Column(name = "PRIVATE_KEY")
	private String privateKey;

	@Column(name = "CHANNEL_STATE")
	private long channelState;

	@Column(name = "CLASS_ADDRESS")
	private String classAddress;

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
