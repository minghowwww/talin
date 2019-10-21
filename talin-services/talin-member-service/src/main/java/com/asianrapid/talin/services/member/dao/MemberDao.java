package com.asianrapid.talin.services.member.dao;

import com.asianrapid.talin.common.domain.dbo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao extends JpaRepository<Customer, Long> {
}
