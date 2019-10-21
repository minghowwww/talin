package com.asianrapid.talin.common.domain.dbo;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "customer")
public class Customer  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private long customerId;

	@Column(name = "customer_no")
	private String customerNo;

	@Column(name = "customer_name")
	private String customerName;

	private long salesman;

	@Column(name = "staff_id")
	private long staffId;

	private long sex;

	@Column(name = "id_number")
	private String idNumber;

	@Column(name = "passport_no")
	private String passportNo;

	private String birthday;

	private long age;

	private String tel;

	@Column(name = "city_id")
	private long cityId;

	private String address;

	@Column(name = "home_phone")
	private String homePhone;

	private String email;

	@Column(name = "work_unit")
	private String workUnit;

	private String remarks;

	@Column(name = "vip_salesman")
	private long vipSalesman;

	@Column(name = "is_verification")
	private long isVerification;

	@Column(name = "customer_source")
	private long customerSource;

	@Column(name = "account_id")
	private long accountId;

	@Column(name = "membership_card_no")
	private String membershipCardNo;

	@Column(name = "alipay_no")
	private String alipayNo;

	@Column(name = "wechat_no")
	private String wechatNo;

	@Column(name = "member_type")
	private String memberType;

	@Column(name = "customer_type")
	private String customerType;

	@Column(name = "black_state")
	private long blackState;

	@Column(name = "customer_star")
	private long customerStar;

	@Column(name = "fwzq_no")
	private String fwzqNo;

	@Column(name = "is_deleted")
	private long isDeleted;

	@Column(name = "update_user_id")
	private long updateUserId;

	@Column(name = "regist_user_id")
	private long registUserId;

	@Column(name = "update_date")
	private java.util.Date updateDate;

	@Column(name = "regist_date")
	private java.util.Date registDate;

	@Column(name = "tel_num")
	private String telNum;

	@Column(name = "id_number_pre")
	private String idNumberPre;


}
