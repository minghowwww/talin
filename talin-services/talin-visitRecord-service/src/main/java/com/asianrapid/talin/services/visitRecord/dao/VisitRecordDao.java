package com.asianrapid.talin.services.visitRecord.dao;

import com.asianrapid.talin.common.domain.dbo.VisitRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRecordDao extends JpaRepository<VisitRecords, Long> {
}
