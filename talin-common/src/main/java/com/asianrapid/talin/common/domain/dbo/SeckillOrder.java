package com.asianrapid.talin.common.domain.dbo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Data
@Entity
@Table(name = "seckill_order")
public class SeckillOrder implements Serializable {

    public SeckillOrder(long activityId, long userId, long payment, long status, long itemId, long createdBy, Date createdTime, long updatedBy, Date updatedTime) {
        this.activityId = activityId;
        this.userId = userId;
        this.payment = payment;
        this.status = status;
        this.itemId = itemId;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
        this.updatedBy = updatedBy;
        this.updatedTime = updatedTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long orderId;

    @Column(name = "activity_id")
    private long activityId;

    @Column(name = "user_id")
    private long userId;

    private long payment;

    @Column(name = "payment_type")
    private long paymentType;

    @Column(name = "post_fee")
    private String postFee;

    private long status;

    @Column(name = "payment_time")
    private java.util.Date paymentTime;

    @Column(name = "consign_time")
    private java.util.Date consignTime;

    @Column(name = "end_time")
    private java.util.Date endTime;

    @Column(name = "close_time")
    private java.util.Date closeTime;

    @Column(name = "buyer_message")
    private String buyerMessage;

    @Column(name = "buyer_rate")
    private long buyerRate;

    @Column(name = "item_id")
    private long itemId;

    private long number;

    @Column(name = "is_deleted")
    private long isDeleted;

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
