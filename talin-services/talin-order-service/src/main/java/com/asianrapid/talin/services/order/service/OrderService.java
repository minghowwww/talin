package com.asianrapid.talin.services.order.service;

import com.asianrapid.talin.common.domain.dbo.Order;
import com.asianrapid.talin.common.exception.TalinServiceException;
import com.asianrapid.talin.common.service.BaseService;
import com.asianrapid.talin.services.order.dao.OrderDao;
import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @ClassName OrderService
 * @Author Nio
 * @Date 2019/8/24 0024
 * @Version V1.0
 **/
@Service
public class OrderService extends BaseService {

    @Autowired
    private OrderDao orderDao;

    @LcnTransaction(propagation = DTXPropagation.SUPPORTS)
    @Transactional
    public void insertOrder(Order order) {
        Order save = orderDao.save(order);
        if (save == null) {
            throw new TalinServiceException();
        }
    }
}
