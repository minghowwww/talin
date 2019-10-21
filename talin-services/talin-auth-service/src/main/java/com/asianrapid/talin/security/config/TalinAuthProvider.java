package com.asianrapid.talin.security.config;

import com.asianrapid.talin.common.domain.User;
import com.asianrapid.talin.common.domain.dbo.Role;
import com.asianrapid.talin.common.domain.dbo.UserRole;
import com.asianrapid.talin.security.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * @ClassName TalinAuthProvider
 * @Description: TODO
 * @Author Nio
 * @Date 2019/8/31 0031
 * @Version V1.0
 **/
public class TalinAuthProvider implements AuthenticationProvider {


    @Autowired
    private UserDao userDao;

    public TalinAuthProvider() {
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user = userDao.findByUsername(authentication.getName());
        return new UsernamePasswordAuthenticationToken(user, authentication.getCredentials(), user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
