package com.rickylee.springbootsticker.dao;

import com.rickylee.springbootsticker.model.User;

public interface UserDao {
    User getUser(Integer userId);
}
