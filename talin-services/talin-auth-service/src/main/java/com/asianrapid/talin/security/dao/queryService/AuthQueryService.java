package com.asianrapid.talin.security.dao.queryService;

import com.asianrapid.talin.common.domain.QUser;
import com.asianrapid.talin.common.domain.dbo.QRole;
import com.asianrapid.talin.common.domain.dbo.QUserRole;
import com.asianrapid.talin.common.domain.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @ClassName AuthQueryService
 * @Description: TODO
 * @Author Nio
 * @Date 2019/10/9 0009
 * @Version V1.0
 **/
@Repository
public class AuthQueryService {

    @Autowired
    private EntityManager entityManager;

    public List<User> findByUsername(String username) {

        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QUser user = QUser.user;
        QUserRole userRole = QUserRole.userRole;
        QRole role = QRole.role;
        return queryFactory.selectFrom(user).leftJoin(user.authorities, userRole).leftJoin(userRole.roleId, role)
                .where(user.username.likeIgnoreCase("%" + username + "%")).fetch();
    }
}
