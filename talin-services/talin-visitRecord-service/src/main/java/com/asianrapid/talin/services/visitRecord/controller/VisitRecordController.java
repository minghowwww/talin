package com.asianrapid.talin.services.visitRecord.controller;

import com.alibaba.fastjson.JSONObject;
import com.asianrapid.talin.api.client.member.VisitRecordServiceApi;
import com.asianrapid.talin.common.controller.BaseController;
import com.asianrapid.talin.common.domain.common.BaseResponse;
import com.asianrapid.talin.common.domain.dbo.VisitRecords;
import com.asianrapid.talin.common.exception.TalinServiceException;
import com.asianrapid.talin.services.visitRecord.service.VisitRecordService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName VisitRecordController
 * @Author Nio
 * @Date 2019/8/21 0021
 * @Version V1.0
 **/
@Api(tags = "客户回访记录服务接口")
@RequestMapping("/visitRecord")
@RestController
public class VisitRecordController extends BaseController implements VisitRecordServiceApi {

    private static final long serialVersionUID = -1441993741581724881L;
    private final VisitRecordService visitRecordService;

    @Autowired
    public VisitRecordController(VisitRecordService visitRecordService) {
        this.visitRecordService = visitRecordService;
    }

    @PostMapping("/insert")
    @Override
    public BaseResponse insertVisitRecord(){

        VisitRecords visitRecords = new VisitRecords();
        visitRecords.setCustomerId(1);
        visitRecords.setVisitContent("666");
        visitRecords.setRegistDate(new Date());
        visitRecords.setUpdateDate(new Date());
        visitRecords.setVisitDate("20190822");
        try {
            visitRecordService.insertVisitRecord(visitRecords);
        } catch (Exception e) {
            throw new TalinServiceException();
        }
        return BaseResponse.ok();
    }
}
