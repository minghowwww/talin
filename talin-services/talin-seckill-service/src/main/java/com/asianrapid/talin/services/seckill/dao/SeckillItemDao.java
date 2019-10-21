package com.asianrapid.talin.services.seckill.dao;

import com.asianrapid.talin.common.domain.dbo.SeckillItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 秒杀商品持久层
 * @author Nio
 */
@Repository
public interface SeckillItemDao extends JpaRepository<SeckillItem, Long> {

    List<SeckillItem> findByActivityId(Long activityId);
}
