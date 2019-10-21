package com.asianrapid.talin.services.item.dao;

import com.asianrapid.talin.common.domain.dbo.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @ClassName ItemDao
 * @Description: 商品持久层
 * @Author Nio
 * @Date 2019/9/17 0017
 * @Version V1.0
 **/
@Repository
public interface ItemDao extends JpaRepository<Item, Long>, JpaSpecificationExecutor<Item>, QuerydslPredicateExecutor<Item> {

}
