package com.asianrapid.talin.consumers.seckill.dao;

import com.asianrapid.talin.common.domain.dbo.SeckillOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeckillOrderDao extends JpaRepository<SeckillOrder, Long> {
}
