package com.rickylee.springbootsticker.service.impl;

import com.rickylee.springbootsticker.dao.UserDao;
import com.rickylee.springbootsticker.dto.UserRequest;
import com.rickylee.springbootsticker.model.User;
import com.rickylee.springbootsticker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(Integer userId) {
        return userDao.getUser(userId);
    }

    @Override
    public Integer createUser(UserRequest userRequest) {
        return userDao.createUser(userRequest);
    }

    @Override
    public void updateUser(Integer userId, UserRequest userRequest) {
        userDao.updateUser(userId, userRequest);
    }
}
