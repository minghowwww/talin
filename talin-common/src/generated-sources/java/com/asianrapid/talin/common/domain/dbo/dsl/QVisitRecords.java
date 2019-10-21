package com.asianrapid.talin.common.domain.dbo.dsl;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.asianrapid.talin.common.domain.dbo.VisitRecords;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QVisitRecords is a Querydsl query type for VisitRecords
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVisitRecords extends EntityPathBase<VisitRecords> {

    private static final long serialVersionUID = -1376163858L;

    public static final QVisitRecords visitRecords = new QVisitRecords("visitRecords");

    public final DateTimePath<java.util.Date> audioEndDate = createDateTime("audioEndDate", java.util.Date.class);

    public final StringPath audioFileName = createString("audioFileName");

    public final StringPath audioFilePath = createString("audioFilePath");

    public final DateTimePath<java.util.Date> audioStartDate = createDateTime("audioStartDate", java.util.Date.class);

    public final NumberPath<Long> customerId = createNumber("customerId", Long.class);

    public final NumberPath<Long> failureCause = createNumber("failureCause", Long.class);

    public final StringPath feedback = createString("feedback");

    public final NumberPath<Long> isDeleted = createNumber("isDeleted", Long.class);

    public final NumberPath<Long> meetingId = createNumber("meetingId", Long.class);

    public final StringPath nextVisitDate = createString("nextVisitDate");

    public final DateTimePath<java.util.Date> registDate = createDateTime("registDate", java.util.Date.class);

    public final NumberPath<Long> registUserId = createNumber("registUserId", Long.class);

    public final StringPath remarks = createString("remarks");

    public final StringPath salesman = createString("salesman");

    public final NumberPath<Long> staffId = createNumber("staffId", Long.class);

    public final StringPath staffName = createString("staffName");

    public final DateTimePath<java.util.Date> updateDate = createDateTime("updateDate", java.util.Date.class);

    public final NumberPath<Long> updateUserId = createNumber("updateUserId", Long.class);

    public final StringPath visitContent = createString("visitContent");

    public final StringPath visitDate = createString("visitDate");

    public final StringPath visitHealthy = createString("visitHealthy");

    public final StringPath visitInvitation = createString("visitInvitation");

    public final NumberPath<Long> visitMode = createNumber("visitMode", Long.class);

    public final NumberPath<Long> visitObjective = createNumber("visitObjective", Long.class);

    public final StringPath visitProduct = createString("visitProduct");

    public final NumberPath<Long> visitRecordsId = createNumber("visitRecordsId", Long.class);

    public final NumberPath<Long> visitResult = createNumber("visitResult", Long.class);

    public final StringPath visitService = createString("visitService");

    public final StringPath visitTravel = createString("visitTravel");

    public final NumberPath<Long> visitType = createNumber("visitType", Long.class);

    public QVisitRecords(String variable) {
        super(VisitRecords.class, forVariable(variable));
    }

    public QVisitRecords(Path<? extends VisitRecords> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVisitRecords(PathMetadata metadata) {
        super(VisitRecords.class, metadata);
    }

}

