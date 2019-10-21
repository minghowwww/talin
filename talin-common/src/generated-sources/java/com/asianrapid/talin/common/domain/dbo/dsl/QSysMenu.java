package com.asianrapid.talin.common.domain.dbo.dsl;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.asianrapid.talin.common.domain.dbo.SysMenu;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSysMenu is a Querydsl query type for SysMenu
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSysMenu extends EntityPathBase<SysMenu> {

    private static final long serialVersionUID = 883380725L;

    public static final QSysMenu sysMenu = new QSysMenu("sysMenu");

    public final NumberPath<Long> createBy = createNumber("createBy", Long.class);

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final StringPath description = createString("description");

    public final NumberPath<Long> isDeleted = createNumber("isDeleted", Long.class);

    public final NumberPath<Long> menuId = createNumber("menuId", Long.class);

    public final StringPath menuName = createString("menuName");

    public final NumberPath<Long> menuRank = createNumber("menuRank", Long.class);

    public final NumberPath<Long> parentMenuId = createNumber("parentMenuId", Long.class);

    public final NumberPath<Long> updateBy = createNumber("updateBy", Long.class);

    public final DateTimePath<java.util.Date> updateTime = createDateTime("updateTime", java.util.Date.class);

    public final StringPath url = createString("url");

    public QSysMenu(String variable) {
        super(SysMenu.class, forVariable(variable));
    }

    public QSysMenu(Path<? extends SysMenu> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSysMenu(PathMetadata metadata) {
        super(SysMenu.class, metadata);
    }

}

