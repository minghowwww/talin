package com.asianrapid.talin.services.pay.dao;

import com.asianrapid.talin.common.domain.dbo.PaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nio
 */
@Repository
public interface PaymentTransactionDao extends JpaRepository<PaymentTransaction, Long> {

    PaymentTransaction findByPaymentId(String paymentId);
}

