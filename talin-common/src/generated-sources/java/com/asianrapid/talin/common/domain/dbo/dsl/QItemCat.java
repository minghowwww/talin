package com.asianrapid.talin.common.domain.dbo.dsl;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.asianrapid.talin.common.domain.dbo.ItemCat;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QItemCat is a Querydsl query type for ItemCat
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QItemCat extends EntityPathBase<ItemCat> {

    private static final long serialVersionUID = 443123692L;

    public static final QItemCat itemCat = new QItemCat("itemCat");

    public final NumberPath<Long> createdBy = createNumber("createdBy", Long.class);

    public final DateTimePath<java.util.Date> createdTime = createDateTime("createdTime", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> isDeleted = createNumber("isDeleted", Long.class);

    public final NumberPath<Long> isParent = createNumber("isParent", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<Long> parentId = createNumber("parentId", Long.class);

    public final NumberPath<Long> sortOrder = createNumber("sortOrder", Long.class);

    public final NumberPath<Long> status = createNumber("status", Long.class);

    public final NumberPath<Long> updatedBy = createNumber("updatedBy", Long.class);

    public final DateTimePath<java.util.Date> updatedTime = createDateTime("updatedTime", java.util.Date.class);

    public QItemCat(String variable) {
        super(ItemCat.class, forVariable(variable));
    }

    public QItemCat(Path<? extends ItemCat> path) {
        super(path.getType(), path.getMetadata());
    }

    public QItemCat(PathMetadata metadata) {
        super(ItemCat.class, metadata);
    }

}

