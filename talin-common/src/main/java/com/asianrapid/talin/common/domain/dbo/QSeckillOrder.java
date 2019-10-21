package com.asianrapid.talin.common.domain.dbo;

import static com.querydsl.core.types.PathMetadataFactory.*;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSeckillOrder is a Querydsl query type for SeckillOrder
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSeckillOrder extends EntityPathBase<SeckillOrder> {

    private static final long serialVersionUID = 449957590L;

    public static final QSeckillOrder seckillOrder = new QSeckillOrder("seckillOrder");

    public final NumberPath<Long> activityId = createNumber("activityId", Long.class);

    public final StringPath buyerMessage = createString("buyerMessage");

    public final NumberPath<Long> buyerRate = createNumber("buyerRate", Long.class);

    public final DateTimePath<java.util.Date> closeTime = createDateTime("closeTime", java.util.Date.class);

    public final DateTimePath<java.util.Date> consignTime = createDateTime("consignTime", java.util.Date.class);

    public final NumberPath<Long> createdBy = createNumber("createdBy", Long.class);

    public final DateTimePath<java.util.Date> createdTime = createDateTime("createdTime", java.util.Date.class);

    public final DateTimePath<java.util.Date> endTime = createDateTime("endTime", java.util.Date.class);

    public final NumberPath<Long> isDeleted = createNumber("isDeleted", Long.class);

    public final NumberPath<Long> itemId = createNumber("itemId", Long.class);

    public final NumberPath<Long> number = createNumber("number", Long.class);

    public final NumberPath<Long> orderId = createNumber("orderId", Long.class);

    public final NumberPath<Long> payment = createNumber("payment", Long.class);

    public final DateTimePath<java.util.Date> paymentTime = createDateTime("paymentTime", java.util.Date.class);

    public final NumberPath<Long> paymentType = createNumber("paymentType", Long.class);

    public final StringPath postFee = createString("postFee");

    public final NumberPath<Long> revision = createNumber("revision", Long.class);

    public final NumberPath<Long> status = createNumber("status", Long.class);

    public final NumberPath<Long> updatedBy = createNumber("updatedBy", Long.class);

    public final DateTimePath<java.util.Date> updatedTime = createDateTime("updatedTime", java.util.Date.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QSeckillOrder(String variable) {
        super(SeckillOrder.class, forVariable(variable));
    }

    public QSeckillOrder(Path<? extends SeckillOrder> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSeckillOrder(PathMetadata metadata) {
        super(SeckillOrder.class, metadata);
    }

}

