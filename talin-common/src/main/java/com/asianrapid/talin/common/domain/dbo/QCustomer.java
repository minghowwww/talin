package com.asianrapid.talin.common.domain.dbo;

import static com.querydsl.core.types.PathMetadataFactory.*;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCustomer is a Querydsl query type for Customer
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCustomer extends EntityPathBase<Customer> {

    private static final long serialVersionUID = 281103573L;

    public static final QCustomer customer = new QCustomer("customer");

    public final NumberPath<Long> accountId = createNumber("accountId", Long.class);

    public final StringPath address = createString("address");

    public final NumberPath<Long> age = createNumber("age", Long.class);

    public final StringPath alipayNo = createString("alipayNo");

    public final StringPath birthday = createString("birthday");

    public final NumberPath<Long> blackState = createNumber("blackState", Long.class);

    public final NumberPath<Long> cityId = createNumber("cityId", Long.class);

    public final NumberPath<Long> customerId = createNumber("customerId", Long.class);

    public final StringPath customerName = createString("customerName");

    public final StringPath customerNo = createString("customerNo");

    public final NumberPath<Long> customerSource = createNumber("customerSource", Long.class);

    public final NumberPath<Long> customerStar = createNumber("customerStar", Long.class);

    public final StringPath customerType = createString("customerType");

    public final StringPath email = createString("email");

    public final StringPath fwzqNo = createString("fwzqNo");

    public final StringPath homePhone = createString("homePhone");

    public final StringPath idNumber = createString("idNumber");

    public final StringPath idNumberPre = createString("idNumberPre");

    public final NumberPath<Long> isDeleted = createNumber("isDeleted", Long.class);

    public final NumberPath<Long> isVerification = createNumber("isVerification", Long.class);

    public final StringPath membershipCardNo = createString("membershipCardNo");

    public final StringPath memberType = createString("memberType");

    public final StringPath passportNo = createString("passportNo");

    public final DateTimePath<java.util.Date> registDate = createDateTime("registDate", java.util.Date.class);

    public final NumberPath<Long> registUserId = createNumber("registUserId", Long.class);

    public final StringPath remarks = createString("remarks");

    public final NumberPath<Long> salesman = createNumber("salesman", Long.class);

    public final NumberPath<Long> sex = createNumber("sex", Long.class);

    public final NumberPath<Long> staffId = createNumber("staffId", Long.class);

    public final StringPath tel = createString("tel");

    public final StringPath telNum = createString("telNum");

    public final DateTimePath<java.util.Date> updateDate = createDateTime("updateDate", java.util.Date.class);

    public final NumberPath<Long> updateUserId = createNumber("updateUserId", Long.class);

    public final NumberPath<Long> vipSalesman = createNumber("vipSalesman", Long.class);

    public final StringPath wechatNo = createString("wechatNo");

    public final StringPath workUnit = createString("workUnit");

    public QCustomer(String variable) {
        super(Customer.class, forVariable(variable));
    }

    public QCustomer(Path<? extends Customer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCustomer(PathMetadata metadata) {
        super(Customer.class, metadata);
    }

}

