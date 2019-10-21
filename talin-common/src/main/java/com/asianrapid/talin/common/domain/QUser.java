package com.asianrapid.talin.common.domain;

import com.asianrapid.talin.common.domain.dbo.QUserRole;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -303784667L;

    public static final QUser user = new QUser("user");

    public final ListPath<com.asianrapid.talin.common.domain.dbo.UserRole, QUserRole> authorities = this.<com.asianrapid.talin.common.domain.dbo.UserRole, QUserRole>createList("authorities", com.asianrapid.talin.common.domain.dbo.UserRole.class, QUserRole.class, PathInits.DIRECT2);

    public final NumberPath<Long> createBy = createNumber("createBy", Long.class);

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> isDeleted = createNumber("isDeleted", Long.class);

    public final NumberPath<Long> isManager = createNumber("isManager", Long.class);

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final StringPath phone = createString("phone");

    public final NumberPath<Long> updateBy = createNumber("updateBy", Long.class);

    public final DateTimePath<java.util.Date> updateTime = createDateTime("updateTime", java.util.Date.class);

    public final StringPath username = createString("username");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

