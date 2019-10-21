package com.asianrapid.talin.security.dao.specification;

import com.asianrapid.talin.common.domain.dbo.User;
import com.github.wenhao.jpa.Specifications;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

/**
 * @ClassName AuthSpecification
 * @Author Nio
 * @Date 2019/9/19 0019
 * @Version V1.0
 **/
@Repository
public class AuthSpecification {

    public Specification findByUsernameSpecification(String username) {
        return Specifications.<User>and()
                .eq("isDeleted", 0)
                .eq("username", username)
                .build();
    }
}
