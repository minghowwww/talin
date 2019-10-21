package com.asianrapid.talin.services.pay.service;

import com.asianrapid.talin.common.domain.PaymentChannel;
import com.asianrapid.talin.common.service.BaseService;
import com.asianrapid.talin.services.pay.dao.PaymentChannelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName PayChannelService
 * @Description: TODO
 * @Author Nio
 * @Date 2019/8/31 0031
 * @Version V1.0
 **/
@Service
public class PayChannelService extends BaseService {

    private final PaymentChannelDao paymentChannelDao;

    @Autowired
    public PayChannelService(PaymentChannelDao paymentChannelDao) {
        this.paymentChannelDao = paymentChannelDao;
    }

    public List<PaymentChannel> listPayChannels() {
        List<PaymentChannel> byChannelStatus = paymentChannelDao.findByChannelState(0L);
        return byChannelStatus;
    }
}
