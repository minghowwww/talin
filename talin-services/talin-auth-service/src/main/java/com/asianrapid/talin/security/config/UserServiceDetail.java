package com.asianrapid.talin.security.config;

import com.asianrapid.talin.security.dao.UserDao;
import com.asianrapid.talin.security.dao.specification.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDetail implements UserDetailsService {

    @Autowired
    private UserDao userRepository;

    @Autowired
    private UserSpecification userSpecification;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByUsername(username);
//        return (UserDetails) userRepository.findAll(userSpecification.findByUsernameSpecification(username)).get(0);
    }

}