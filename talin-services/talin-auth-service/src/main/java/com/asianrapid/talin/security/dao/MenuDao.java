package com.asianrapid.talin.security.dao;

import com.asianrapid.talin.common.domain.dbo.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName MenuDao
 * @Author Nio
 * @Date 2019/9/19 0019
 * @Version V1.0
 **/
@Repository
public interface MenuDao extends JpaRepository<SysMenu, Long>, JpaSpecificationExecutor<SysMenu> {
    SysMenu findByMenuIdAndMenuRank(Long menuId, Long rank);

    List<SysMenu> findByParentMenuId(Long parentMenuId);
}
