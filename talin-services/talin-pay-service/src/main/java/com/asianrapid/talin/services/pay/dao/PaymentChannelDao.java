package com.asianrapid.talin.services.pay.dao;

import com.asianrapid.talin.common.domain.PaymentChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName PaymentChannelDao
 * @Description: TODO
 * @Author Nio
 * @Date 2019/8/30 0030
 * @Version V1.0
 **/
@Repository
public interface PaymentChannelDao extends JpaRepository<PaymentChannel, Long> {

    /**
     * 根据渠道类型查询支付渠道信息
     * @param channelState
     * @return
     */
    List<PaymentChannel> findByChannelState(Long channelState);

    /**
     * 根据渠道id查询支付渠道信息
     * @param channelId
     * @return
     */
    PaymentChannel findByChannelId(String channelId);
}
