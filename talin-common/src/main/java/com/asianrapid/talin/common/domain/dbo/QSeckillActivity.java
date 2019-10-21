package com.asianrapid.talin.common.domain.dbo;

import static com.querydsl.core.types.PathMetadataFactory.*;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSeckillActivity is a Querydsl query type for SeckillActivity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSeckillActivity extends EntityPathBase<SeckillActivity> {

    private static final long serialVersionUID = 1498422919L;

    public static final QSeckillActivity seckillActivity = new QSeckillActivity("seckillActivity");

    public final NumberPath<Long> activityId = createNumber("activityId", Long.class);

    public final NumberPath<Long> createdBy = createNumber("createdBy", Long.class);

    public final DateTimePath<java.util.Date> createdTime = createDateTime("createdTime", java.util.Date.class);

    public final DateTimePath<java.util.Date> endTime = createDateTime("endTime", java.util.Date.class);

    public final NumberPath<Long> revision = createNumber("revision", Long.class);

    public final DateTimePath<java.util.Date> startTime = createDateTime("startTime", java.util.Date.class);

    public final NumberPath<Long> status = createNumber("status", Long.class);

    public final NumberPath<Long> updatedBy = createNumber("updatedBy", Long.class);

    public final DateTimePath<java.util.Date> updatedTime = createDateTime("updatedTime", java.util.Date.class);

    public QSeckillActivity(String variable) {
        super(SeckillActivity.class, forVariable(variable));
    }

    public QSeckillActivity(Path<? extends SeckillActivity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSeckillActivity(PathMetadata metadata) {
        super(SeckillActivity.class, metadata);
    }

}

