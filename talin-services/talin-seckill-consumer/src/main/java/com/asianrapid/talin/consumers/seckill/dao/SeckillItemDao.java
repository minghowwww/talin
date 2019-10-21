package com.asianrapid.talin.consumers.seckill.dao;

import com.asianrapid.talin.common.domain.dbo.SeckillItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SeckillItemDao extends JpaRepository<SeckillItem, Long>, JpaSpecificationExecutor<SeckillItem> {

    @Modifying
    @Query("update SeckillItem si set si.number = si.number - 1 where si.number > 0 and si.activityId = :activityId and si.itemId = :ItemId")
    Integer updateItemNumbers(Long activityId, Long ItemId);

    SeckillItem findByActivityIdAndItemId(Long activityId, Long itemId);
}
