package com.asianrapid.talin.security.dao;

import com.asianrapid.talin.common.domain.dbo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author Nio
 */
@Repository
public interface AuthDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
}
