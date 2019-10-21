package com.asianrapid.talin.services.pay.dao;

import com.asianrapid.talin.common.domain.dbo.PaymentTransactionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nio
 */
@Repository
public interface PaymentTransactionLogDao extends JpaRepository<PaymentTransactionLog, Long> {
}
