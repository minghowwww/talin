package com.asianrapid.talin.services.member.service;

import com.alibaba.fastjson.JSONObject;
import com.asianrapid.talin.api.client.member.VisitRecordServiceApi;
import com.asianrapid.talin.api.client.order.OrderServiceApi;
import com.asianrapid.talin.api.client.weixin.WeixinServiceApi;
import com.asianrapid.talin.common.domain.common.BaseResponse;
import com.asianrapid.talin.common.domain.dbo.Customer;
import com.asianrapid.talin.common.domain.dto.weixin.AppEntity;
import com.asianrapid.talin.common.exception.TalinServiceException;
import com.asianrapid.talin.common.service.BaseService;
import com.asianrapid.talin.services.member.dao.MemberDao;
import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.annotation.TxTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @ClassName MemberService
 * @Description: TODO
 * @Author Nio
 * @Date 2019/8/21 0021
 * @Version V1.0
 **/
@Service
public class MemberService extends BaseService {

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private VisitRecordServiceApi visitRecordServiceApi;

    @Autowired
    private WeixinServiceApi weixinServiceApi;

    @Autowired
    private OrderServiceApi orderServiceApi;

    public BaseResponse<AppEntity> testWeixin() {
        return weixinServiceApi.getAppInfo();
    }

    @LcnTransaction(propagation = DTXPropagation.REQUIRED)
    @Transactional(rollbackOn = Exception.class)
    public void insertCustomer(Customer customer) {
        Customer save = memberDao.save(customer);
        if (save == null) {
            throw new TalinServiceException();
        }
        BaseResponse baseResponse = visitRecordServiceApi.insertVisitRecord();
        checkFeignClientResponse(baseResponse);

        throw new RuntimeException();
    }
}
