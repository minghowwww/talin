package com.asianrapid.talin.common.domain.dbo.dsl;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.asianrapid.talin.common.domain.dbo.Role;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRole is a Querydsl query type for Role
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRole extends EntityPathBase<Role> {

    private static final long serialVersionUID = -1564974867L;

    public static final QRole role = new QRole("role");

    public final NumberPath<Long> createBy = createNumber("createBy", Long.class);

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> isDeleted = createNumber("isDeleted", Long.class);

    public final StringPath menuList = createString("menuList");

    public final StringPath name = createString("name");

    public final StringPath roleCode = createString("roleCode");

    public final NumberPath<Long> updateBy = createNumber("updateBy", Long.class);

    public final DateTimePath<java.util.Date> updateTime = createDateTime("updateTime", java.util.Date.class);

    public QRole(String variable) {
        super(Role.class, forVariable(variable));
    }

    public QRole(Path<? extends Role> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRole(PathMetadata metadata) {
        super(Role.class, metadata);
    }

}

