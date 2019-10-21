package com.asianrapid.talin.servcies.auth;

import com.asianrapid.talin.AuthApplication;
import com.asianrapid.talin.security.dao.UserDao;
import com.asianrapid.talin.security.dao.specification.UserSpecification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName AuthTest
 * @Author Nio
 * @Date 2019/9/18 0018
 * @Version V1.0
 **/
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = AuthApplication.class)
public class AuthTest {

//    @Autowired
//    private UserDao userDao;
//
//    @Autowired
//    private UserSpecification userSpecification;
//
//    @Autowired
//    private MessageSource messageSource;
//
//    @Test
//    @Transactional
    public void testCreateIndex() {
//        Sort sort = "ASC".equals(sortType) ? new Sort(Sort.Direction.ASC, sortableFields) : new Sort(Sort.Direction.DESC, sortableFields);
//        Pageable pageable = new PageRequest(0,2);
//        Page<User> all = userDao.findAll(userSpecification.findUserlist(""), pageable);
//        CommonGrid<UserListDMO> grid = new CommonGrid<>(all, UserListDMO.class);
//        System.out.println(grid.getTotalRecords());
//        System.out.println(grid.getTotalPages());
//        for (UserListDMO dto : grid.getRowList()) {
//
//            System.out.println(dto.getUsername());
//        }

//        List<User> all = userDao.findAll(userSpecification.findByUsernameSpecification("nio"));
//        User user = all.get(0);
//        List<UserRole> authorities = user.getAuthorities();
//        System.out.println(authorities.get(0).getRoleId().getMenuList());

//        String x = messageSource.getMessage("error.isblank", null, null);
//        System.out.println(x);
    }
}
