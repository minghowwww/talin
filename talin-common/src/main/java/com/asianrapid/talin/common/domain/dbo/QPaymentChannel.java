package com.asianrapid.talin.common.domain.dbo;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.asianrapid.talin.common.domain.PaymentChannel;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPaymentChannel is a Querydsl query type for PaymentChannel
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPaymentChannel extends EntityPathBase<PaymentChannel> {

    private static final long serialVersionUID = -501352201L;

    public static final QPaymentChannel paymentChannel = new QPaymentChannel("paymentChannel");

    public final StringPath asynUrl = createString("asynUrl");

    public final StringPath channelId = createString("channelId");

    public final StringPath channelName = createString("channelName");

    public final NumberPath<Long> channelState = createNumber("channelState", Long.class);

    public final StringPath classAddress = createString("classAddress");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.util.Date> createdTime = createDateTime("createdTime", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath merchantId = createString("merchantId");

    public final StringPath privateKey = createString("privateKey");

    public final StringPath publicKey = createString("publicKey");

    public final NumberPath<Long> revision = createNumber("revision", Long.class);

    public final StringPath syncUrl = createString("syncUrl");

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.util.Date> updatedTime = createDateTime("updatedTime", java.util.Date.class);

    public QPaymentChannel(String variable) {
        super(PaymentChannel.class, forVariable(variable));
    }

    public QPaymentChannel(Path<? extends PaymentChannel> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPaymentChannel(PathMetadata metadata) {
        super(PaymentChannel.class, metadata);
    }

}

