package com.asianrapid.talin.common.domain.dbo.dsl;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.asianrapid.talin.common.domain.dbo.PaymentTransaction;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPaymentTransaction is a Querydsl query type for PaymentTransaction
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPaymentTransaction extends EntityPathBase<PaymentTransaction> {

    private static final long serialVersionUID = 1105079599L;

    public static final QPaymentTransaction paymentTransaction = new QPaymentTransaction("paymentTransaction");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.util.Date> createdTime = createDateTime("createdTime", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath orderId = createString("orderId");

    public final NumberPath<Long> payAmount = createNumber("payAmount", Long.class);

    public final NumberPath<Long> paymentChannel = createNumber("paymentChannel", Long.class);

    public final StringPath paymentId = createString("paymentId");

    public final NumberPath<Long> paymentStatus = createNumber("paymentStatus", Long.class);

    public final NumberPath<Long> revision = createNumber("revision", Long.class);

    public final StringPath thirdPartyPaymentId = createString("thirdPartyPaymentId");

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.util.Date> updatedTime = createDateTime("updatedTime", java.util.Date.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QPaymentTransaction(String variable) {
        super(PaymentTransaction.class, forVariable(variable));
    }

    public QPaymentTransaction(Path<? extends PaymentTransaction> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPaymentTransaction(PathMetadata metadata) {
        super(PaymentTransaction.class, metadata);
    }

}

