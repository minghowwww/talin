package com.asianrapid.talin.common.domain.dbo.dsl;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.asianrapid.talin.common.domain.dbo.Order;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QOrder is a Querydsl query type for Order
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOrder extends EntityPathBase<Order> {

    private static final long serialVersionUID = -1272269385L;

    public static final QOrder order = new QOrder("order1");

    public final StringPath billNo = createString("billNo");

    public final NumberPath<Long> changeStatus = createNumber("changeStatus", Long.class);

    public final StringPath contractNo = createString("contractNo");

    public final NumberPath<Long> customerId = createNumber("customerId", Long.class);

    public final StringPath delFlag = createString("delFlag");

    public final NumberPath<Long> deptId = createNumber("deptId", Long.class);

    public final NumberPath<Long> feeStatus = createNumber("feeStatus", Long.class);

    public final NumberPath<Long> goodsId = createNumber("goodsId", Long.class);

    public final NumberPath<Long> meetingId = createNumber("meetingId", Long.class);

    public final DateTimePath<java.util.Date> orderDate = createDateTime("orderDate", java.util.Date.class);

    public final NumberPath<Long> orderId = createNumber("orderId", Long.class);

    public final NumberPath<Long> orderKbn = createNumber("orderKbn", Long.class);

    public final StringPath orderNo = createString("orderNo");

    public final NumberPath<Long> orderPreStatus = createNumber("orderPreStatus", Long.class);

    public final NumberPath<Long> orderStatus = createNumber("orderStatus", Long.class);

    public final NumberPath<Double> paid = createNumber("paid", Double.class);

    public final DateTimePath<java.util.Date> registDate = createDateTime("registDate", java.util.Date.class);

    public final StringPath registUser = createString("registUser");

    public final StringPath remark = createString("remark");

    public final NumberPath<Long> salesman = createNumber("salesman", Long.class);

    public final NumberPath<Long> staffId = createNumber("staffId", Long.class);

    public final StringPath staffName = createString("staffName");

    public final NumberPath<Double> sumPrice = createNumber("sumPrice", Double.class);

    public final DateTimePath<java.util.Date> updateDate = createDateTime("updateDate", java.util.Date.class);

    public final StringPath updateUser = createString("updateUser");

    public QOrder(String variable) {
        super(Order.class, forVariable(variable));
    }

    public QOrder(Path<? extends Order> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrder(PathMetadata metadata) {
        super(Order.class, metadata);
    }

}

