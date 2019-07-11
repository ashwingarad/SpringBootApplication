package com.service.impl;

import com.controller.form.UserForm;
import com.dao.UserDao;
import com.dao.model.UserMaster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserDetailsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserDao userDao;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserMaster userMaster = userDao.getUserByName(username);
        if (userMaster == null) {
            throw new UsernameNotFoundException("User not exist");
        }
        return new UserForm(userMaster);
    }
}
