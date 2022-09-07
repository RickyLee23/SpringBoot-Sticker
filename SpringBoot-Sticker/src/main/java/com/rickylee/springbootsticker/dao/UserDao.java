package com.rickylee.springbootsticker.dao;

import com.rickylee.springbootsticker.dto.UserRequest;
import com.rickylee.springbootsticker.model.User;

public interface UserDao {
    User getUser(Integer userId);
    Integer createUser(UserRequest userRequest);
    void updateUser(Integer userId, UserRequest userRequest);
}
