package com.rickylee.springbootsticker.service;

import com.rickylee.springbootsticker.dto.UserRequest;
import com.rickylee.springbootsticker.model.User;

public interface UserService {

    User getUser(Integer userId);
    Integer createUser(UserRequest userRequest);
    void updateUser(Integer userId, UserRequest userRequest);
    void deleteUser(Integer userId);
}