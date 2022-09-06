package com.rickylee.springbootsticker.service.impl;

import com.rickylee.springbootsticker.dao.UserDao;
import com.rickylee.springbootsticker.model.User;
import com.rickylee.springbootsticker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class userServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(Integer userId) {
        System.out.println(userId);
        return userDao.getUser(userId);
    }
}
