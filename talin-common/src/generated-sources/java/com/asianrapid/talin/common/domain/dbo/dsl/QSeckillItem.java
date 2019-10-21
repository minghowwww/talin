package com.asianrapid.talin.common.domain.dbo.dsl;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.asianrapid.talin.common.domain.dbo.SeckillItem;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSeckillItem is a Querydsl query type for SeckillItem
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSeckillItem extends EntityPathBase<SeckillItem> {

    private static final long serialVersionUID = -1371135349L;

    public static final QSeckillItem seckillItem = new QSeckillItem("seckillItem");

    public final NumberPath<Long> activityId = createNumber("activityId", Long.class);

    public final StringPath barcode = createString("barcode");

    public final StringPath cid = createString("cid");

    public final NumberPath<Long> createdBy = createNumber("createdBy", Long.class);

    public final DateTimePath<java.util.Date> createdTime = createDateTime("createdTime", java.util.Date.class);

    public final StringPath description = createString("description");

    public final StringPath image = createString("image");

    public final NumberPath<Long> itemId = createNumber("itemId", Long.class);

    public final NumberPath<Long> number = createNumber("number", Long.class);

    public final NumberPath<Long> price = createNumber("price", Long.class);

    public final NumberPath<Long> revision = createNumber("revision", Long.class);

    public final StringPath sellPoint = createString("sellPoint");

    public final StringPath status = createString("status");

    public final StringPath title = createString("title");

    public final NumberPath<Long> updatedBy = createNumber("updatedBy", Long.class);

    public final DateTimePath<java.util.Date> updatedTime = createDateTime("updatedTime", java.util.Date.class);

    public QSeckillItem(String variable) {
        super(SeckillItem.class, forVariable(variable));
    }

    public QSeckillItem(Path<? extends SeckillItem> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSeckillItem(PathMetadata metadata) {
        super(SeckillItem.class, metadata);
    }

}

