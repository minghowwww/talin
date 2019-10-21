package com.asianrapid.talin.common.domain.dbo.primaryKey.dsl;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.asianrapid.talin.common.domain.dbo.primaryKey.UserRolePK;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserRolePK is a Querydsl query type for UserRolePK
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QUserRolePK extends BeanPath<UserRolePK> {

    private static final long serialVersionUID = -1174409514L;

    public static final QUserRolePK userRolePK = new QUserRolePK("userRolePK");

    public final NumberPath<Long> roleId = createNumber("roleId", Long.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QUserRolePK(String variable) {
        super(UserRolePK.class, forVariable(variable));
    }

    public QUserRolePK(Path<? extends UserRolePK> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserRolePK(PathMetadata metadata) {
        super(UserRolePK.class, metadata);
    }

}

