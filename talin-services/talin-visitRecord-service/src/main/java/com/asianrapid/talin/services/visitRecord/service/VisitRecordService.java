package com.asianrapid.talin.services.visitRecord.service;

import com.asianrapid.talin.common.domain.dbo.VisitRecords;
import com.asianrapid.talin.common.exception.TalinServiceException;
import com.asianrapid.talin.common.service.BaseService;
import com.asianrapid.talin.services.visitRecord.dao.VisitRecordDao;
import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @ClassName VisitRecordServcie
 * @Author Nio
 * @Date 2019/8/21 0021
 * @Version V1.0
 **/
@Service
public class VisitRecordService extends BaseService {
    private final VisitRecordDao visitRecordDao;

    @Autowired
    public VisitRecordService(VisitRecordDao visitRecordDao) {
        this.visitRecordDao = visitRecordDao;
    }

    @LcnTransaction(propagation = DTXPropagation.SUPPORTS)
    @Transactional
    public void insertVisitRecord(VisitRecords visitRecords) {

        VisitRecords save = visitRecordDao.save(visitRecords);
        if (save == null) {
            throw new TalinServiceException();
        }
    }
}
