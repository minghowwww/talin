package com.asianrapid.talin.common.domain.dbo;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "payment_transaction_log")
public class PaymentTransactionLog  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@Column(name = "SYNCH_LOG")
	private String synchLog;

	@Column(name = "ASYNC_LOG")
	private String asyncLog;

	@Column(name = "CHANNEL_ID")
	private long channelId;

	@Column(name = "TRANSACTION_ID")
	private String transactionId;

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

	private String untitled;


}
