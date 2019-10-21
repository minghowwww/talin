package com.asianrapid.talin.common.domain.dbo;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "order")
public class Order  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "order_id")
	private long orderId;

	@Column(name = "order_no")
	private String orderNo;

	@Column(name = "customer_id")
	private long customerId;

	@Column(name = "order_kbn")
	private long orderKbn;

	@Column(name = "staff_id")
	private long staffId;

	@Column(name = "staff_name")
	private String staffName;

	private long salesman;

	@Column(name = "dept_id")
	private long deptId;

	@Column(name = "order_date")
	private java.util.Date orderDate;

	@Column(name = "bill_no")
	private String billNo;

	@Column(name = "contract_no")
	private String contractNo;

	@Column(name = "order_status")
	private long orderStatus;

	@Column(name = "order_pre_status")
	private long orderPreStatus;

	@Column(name = "change_status")
	private long changeStatus;

	@Column(name = "fee_status")
	private long feeStatus;

	@Column(name = "sum_price")
	private double sumPrice;

	private double paid;

	@Column(name = "meeting_id")
	private long meetingId;

	private String remark;

	@Column(name = "del_flag")
	private String delFlag;

	@Column(name = "regist_user")
	private String registUser;

	@Column(name = "regist_date")
	private java.util.Date registDate;

	@Column(name = "update_user")
	private String updateUser;

	@Column(name = "update_date")
	private java.util.Date updateDate;

	@Column(name = "goods_id")
	private long goodsId;


}
