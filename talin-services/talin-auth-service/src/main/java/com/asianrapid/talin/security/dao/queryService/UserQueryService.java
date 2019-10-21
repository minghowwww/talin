package com.asianrapid.talin.security.dao.queryService;

import com.asianrapid.talin.common.domain.QUser;
import com.asianrapid.talin.common.domain.User;
import com.asianrapid.talin.common.domain.common.CommonGrid;
import com.asianrapid.talin.common.domain.common.TableRow;
import com.asianrapid.talin.common.domain.dmo.UserListDMO;
import com.asianrapid.talin.security.dao.UserDao;
import com.github.wenhao.jpa.Specifications;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @ClassName UserQueryService
 * @Description: TODO
 * @Author Nio
 * @Date 2019/10/9 0009
 * @Version V1.0
 **/
@Repository
public class UserQueryService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private EntityManager entityManager;

    public User findByUserId(String userId) {
        QUser user = QUser.user;
        Predicate predicate = user.isDeleted.eq(0L).and(user.id.eq(NumberUtils.parseNumber(userId, Long.class)));
        List<User> all = (List<User>) userDao.findAll(predicate);
        return all.get(0);
    }

    /**
     * 用户列表查询
     * @param username
     * @return
     */
    public CommonGrid<UserListDMO> findUserlist(String username, Long offset, Long pageSize) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QUser user = QUser.user;
        JPAQuery<User> predicate = queryFactory.selectFrom(user).where(user.isDeleted.eq(0L));
        if (!StringUtils.isEmpty(username)) {
            predicate.where(user.username.likeIgnoreCase("%" + username + "%"));
        }

        predicate.offset(offset).limit(pageSize);
        QueryResults<User> results = predicate.fetchResults();
        return new CommonGrid<>(results, UserListDMO.class);
    }
}
