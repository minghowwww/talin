package com.asianrapid.talin.common.domain.dbo.dsl;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.asianrapid.talin.common.domain.dbo.PaymentTransactionLog;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPaymentTransactionLog is a Querydsl query type for PaymentTransactionLog
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPaymentTransactionLog extends EntityPathBase<PaymentTransactionLog> {

    private static final long serialVersionUID = 502086549L;

    public static final QPaymentTransactionLog paymentTransactionLog = new QPaymentTransactionLog("paymentTransactionLog");

    public final StringPath asyncLog = createString("asyncLog");

    public final NumberPath<Long> channelId = createNumber("channelId", Long.class);

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.util.Date> createdTime = createDateTime("createdTime", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> revision = createNumber("revision", Long.class);

    public final StringPath synchLog = createString("synchLog");

    public final StringPath transactionId = createString("transactionId");

    public final StringPath untitled = createString("untitled");

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.util.Date> updatedTime = createDateTime("updatedTime", java.util.Date.class);

    public QPaymentTransactionLog(String variable) {
        super(PaymentTransactionLog.class, forVariable(variable));
    }

    public QPaymentTransactionLog(Path<? extends PaymentTransactionLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPaymentTransactionLog(PathMetadata metadata) {
        super(PaymentTransactionLog.class, metadata);
    }

}

