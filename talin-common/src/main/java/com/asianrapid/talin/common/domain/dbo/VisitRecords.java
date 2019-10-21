package com.asianrapid.talin.common.domain.dbo;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "visit_records")
public class VisitRecords implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "visit_records_id")
	private long visitRecordsId;

	@Column(name = "customer_id")
	private long customerId;

	@Column(name = "visit_type")
	private long visitType;

	@Column(name = "visit_date")
	private String visitDate;

	@Column(name = "staff_id")
	private long staffId;

	@Column(name = "staff_name")
	private String staffName;

	private String salesman;

	@Column(name = "next_visit_date")
	private String nextVisitDate;

	@Column(name = "meeting_id")
	private long meetingId;

	@Column(name = "visit_mode")
	private long visitMode;

	@Column(name = "visit_objective")
	private long visitObjective;

	@Column(name = "visit_healthy")
	private String visitHealthy;

	@Column(name = "visit_travel")
	private String visitTravel;

	@Column(name = "visit_service")
	private String visitService;

	@Column(name = "visit_product")
	private String visitProduct;

	@Column(name = "visit_Invitation")
	private String visitInvitation;

	@Column(name = "visit_content")
	private String visitContent;

	private String feedback;

	@Column(name = "visit_result")
	private long visitResult;

	@Column(name = "failure_cause")
	private long failureCause;

	@Column(name = "audio_start_date")
	private java.util.Date audioStartDate;

	@Column(name = "audio_end_date")
	private java.util.Date audioEndDate;

	@Column(name = "audio_file_name")
	private String audioFileName;

	@Column(name = "audio_file_path")
	private String audioFilePath;

	private String remarks;

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


}
