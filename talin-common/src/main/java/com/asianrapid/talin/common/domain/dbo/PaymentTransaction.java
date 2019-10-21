package com.asianrapid.talin.common.domain.dbo;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.security.PrivateKey;


@Data
@Entity
@Table(name = "payment_transaction")
public class PaymentTransaction  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@Column(name = "PAYMENT_ID")
	private String paymentId;

	@Column(name = "PAYMENT_CHANNEL")
	private Long paymentChannel;

	@Column(name = "THIRD_PARTY_PAYMENT_ID")
	private String thirdPartyPaymentId;

	@Column(name = "PAY_AMOUNT")
	private long payAmount;

	@Column(name = "PAYMENT_STATUS")
	private Long paymentStatus;

	@Column(name = "USER_ID")
	private long userId;

	@Column(name = "ORDER_ID")
	private String orderId;

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
