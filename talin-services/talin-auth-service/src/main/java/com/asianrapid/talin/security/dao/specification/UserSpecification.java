package com.asianrapid.talin.security.dao.specification;

import com.asianrapid.talin.common.domain.User;
import com.github.wenhao.jpa.Specifications;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

/**
 * @ClassName UserSpecification
 * @Author Nio
 * @Date 2019/9/18 0018
 * @Version V1.0
 **/
@Repository
public class UserSpecification {
    public Specification findByUsernameSpecification(String username) {
        return Specifications.<User>and()
                .eq("isDeleted", 0)
                .eq("username", username)
                .build();
    }

    public Specification findByUserIdSpecification(String userId) {
        return Specifications.<User>and()
                .eq("isDeleted", 0)
                .eq("id", userId)
                .build();
    }

    /**
     * 用户列表查询
     * @param username
     * @return
     */
    public Specification findUserlist(String username) {
        Specifications specifications = new Specifications();
        Specification<User> findUserlist = null;
        if (!StringUtils.isEmpty(username)){
            findUserlist = specifications.<User>and().like("username", "%" + username + "%")
                    .eq("isDeleted", 0).build();
        } else {

            findUserlist = specifications.<User>and().eq("isDeleted", 0).build();
        }
        return findUserlist;
    }
}
