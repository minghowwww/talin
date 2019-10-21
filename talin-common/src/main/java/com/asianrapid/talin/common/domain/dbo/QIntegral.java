package com.asianrapid.talin.common.domain.dbo;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.asianrapid.talin.common.domain.Integral;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QIntegral is a Querydsl query type for Integral
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QIntegral extends EntityPathBase<Integral> {

    private static final long serialVersionUID = 878463494L;

    public static final QIntegral integral1 = new QIntegral("integral1");

    public final NumberPath<Long> availability = createNumber("availability", Long.class);

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.util.Date> createdTime = createDateTime("createdTime", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath integral = createString("integral");

    public final StringPath paymentId = createString("paymentId");

    public final NumberPath<Long> revision = createNumber("revision", Long.class);

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.util.Date> updatedTime = createDateTime("updatedTime", java.util.Date.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QIntegral(String variable) {
        super(Integral.class, forVariable(variable));
    }

    public QIntegral(Path<? extends Integral> path) {
        super(path.getType(), path.getMetadata());
    }

    public QIntegral(PathMetadata metadata) {
        super(Integral.class, metadata);
    }

}

