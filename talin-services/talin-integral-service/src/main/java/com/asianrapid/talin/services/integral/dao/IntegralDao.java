package com.asianrapid.talin.services.integral.dao;

import com.asianrapid.talin.common.domain.Integral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nio
 */
@Repository
public interface IntegralDao extends JpaRepository<Integral, Long> {

    Integral findByPaymentId(String paymentId);
}

