package com.asianrapid.talin.services.pay.service;

import com.asianrapid.talin.api.client.pay.PayServiceApi;
import com.asianrapid.talin.common.consts.SystemMessageConst;
import com.asianrapid.talin.common.domain.PaymentChannel;
import com.asianrapid.talin.common.domain.common.BaseResponse;
import com.asianrapid.talin.common.domain.dbo.PaymentTransaction;
import com.asianrapid.talin.common.domain.dto.pay.GetPayDTO;
import com.asianrapid.talin.common.domain.dto.pay.PaymentTransactionDTO;
import com.asianrapid.talin.common.exception.TalinServiceException;
import com.asianrapid.talin.common.service.BaseService;
import com.asianrapid.talin.common.utils.GenerateToken;
import com.asianrapid.talin.common.utils.RedisUtil;
import com.asianrapid.talin.common.utils.SnowflakeIdUtils;
import com.asianrapid.talin.services.pay.dao.PaymentChannelDao;
import com.asianrapid.talin.services.pay.dao.PaymentTransactionDao;
import com.asianrapid.talin.services.pay.factory.StrategyFactory;
import com.asianrapid.talin.services.pay.strategy.PayStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

/**
 * @ClassName PayService
 * @Description: 支付服务业务逻辑层
 * @Author Nio
 * @Date 2019/8/30 0030
 * @Version V1.0
 **/
@Service
public class PayService extends BaseService {

    private final PaymentTransactionDao paymentTransactionDao;

    private final PaymentChannelDao paymentChannelDao;

    private final GenerateToken generateTokenl;

    private final PayServiceApi payServiceApi;

    private final RedisUtil redisUtil;

    @Autowired
    public PayService(PaymentTransactionDao paymentTransactionDao, PaymentChannelDao paymentChannelDao, GenerateToken generateTokenl, PayServiceApi payServiceApi, RedisUtil redisUtil) {
        this.paymentTransactionDao = paymentTransactionDao;
        this.paymentChannelDao = paymentChannelDao;
        this.generateTokenl = generateTokenl;
        this.payServiceApi = payServiceApi;
        this.redisUtil = redisUtil;
    }

    @Transactional(rollbackOn = Exception.class)
    public BaseResponse<String> getPayToken(GetPayDTO getPayDTO) {
        debugLog("获取支付令牌参数" + getPayDTO.toString());
        PaymentTransaction paymentTransaction = new PaymentTransaction();
        paymentTransaction.setOrderId(getPayDTO.getOrderId());
        paymentTransaction.setUserId(getPayDTO.getCustomerId());
        paymentTransaction.setPayAmount(getPayDTO.getAmount());
        paymentTransaction.setPaymentStatus(0L);
        paymentTransaction.setCreatedTime(new Date());

        paymentTransaction.setCreatedBy(String.valueOf(getCurrentUserId()));

        paymentTransaction.setPaymentId(SnowflakeIdUtils.nextId());
        PaymentTransaction save = paymentTransactionDao.save(paymentTransaction);

        if (save == null) {
            throw new TalinServiceException(SystemMessageConst.PAY_ERROR_MESSAGE);
        }
        String token = generateTokenl.createToken("pay_", save.getId() + "", 600L);

        return BaseResponse.ok(token);
    }

    public BaseResponse<PaymentTransactionDTO> getPayTransactionDetailByToken(String token) {
        debugLog("支付令牌=" + token);
        String payId = generateTokenl.getToken(token);
        Optional<PaymentTransaction> paymentTransaction = paymentTransactionDao.findById(NumberUtils.parseNumber(payId, Long.class));

        paymentTransaction.orElseThrow(TalinServiceException::new);
        PaymentTransaction transaction = paymentTransaction.get();

        PaymentTransactionDTO paymentTransactionDTO = new PaymentTransactionDTO();
        paymentTransactionDTO.setCreatedTime(transaction.getCreatedTime());
        paymentTransactionDTO.setOrderId(transaction.getOrderId());
        paymentTransactionDTO.setPayAmount(transaction.getPayAmount());
        paymentTransactionDTO.setPaymentId(transaction.getPaymentId());
        return BaseResponse.ok(paymentTransactionDTO);
    }

    public String getPayHtml(String token, String channelId) {
        PaymentChannel paymentChannel = paymentChannelDao.findByChannelId(channelId);
        BaseResponse<PaymentTransactionDTO> response = getPayTransactionDetailByToken(token);
        checkFeignClientResponse(response);
        PayStrategy payStrategy = StrategyFactory.getPayStrategy(paymentChannel.getClassAddress());
        String payHtml = payStrategy.getPayHtml(paymentChannel, response.getData());

        return payHtml;
    }
}
