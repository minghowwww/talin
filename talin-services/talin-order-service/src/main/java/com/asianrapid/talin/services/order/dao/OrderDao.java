package com.asianrapid.talin.services.order.dao;

import com.asianrapid.talin.common.domain.dbo.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName OrderDao
 * @Description: TODO
 * @Author Nio
 * @Date 2019/8/24 0024
 * @Version V1.0
 **/
public interface OrderDao extends JpaRepository<Order, Long> {
}
