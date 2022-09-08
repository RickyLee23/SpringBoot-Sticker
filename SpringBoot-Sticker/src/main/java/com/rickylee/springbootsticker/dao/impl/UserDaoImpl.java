package com.rickylee.springbootsticker.dao.impl;

import com.rickylee.springbootsticker.dao.UserDao;
import com.rickylee.springbootsticker.dto.UserRequest;
import com.rickylee.springbootsticker.model.User;
import com.rickylee.springbootsticker.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public User getUser(Integer userId) {
        String sql = "SELECT user_id, user_name, user_image_url, " +
                "user_description, created_date, last_modified_date " +
                "FROM user WHERE user_id = :userId";

        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);

        List<User> userList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());
        if (userList.size() > 0) {
            return userList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Integer createUser(UserRequest userRequest) {
        String sql = "INSERT INTO user (user_name, user_image_url, user_description, created_date, last_modified_date)"
                + "VALUES (:userName, :userImageUrl, :userDescription, :createdDate, :lastModifiedDate)";

        Map<String, Object> map = new HashMap<>();
        map.put("userName", userRequest.getUserName());
        map.put("userImageUrl", userRequest.getUserImageUrl());
        map.put("userDescription", userRequest.getUserDescription());

        Date now = new Date();
        map.put("createdDate", now);
        map.put("lastModifiedDate", now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int userId = keyHolder.getKey().intValue();

        return userId;
    }

    @Override
    public void updateUser(Integer userId, UserRequest userRequest) {
        String sql = "UPDATE user SET user_name = :userName, user_image_url = :userImageUrl, user_description = :userDescription" +
                ", last_modified_date = :lastModifiedDate " +
                "WHERE user_id = :userId";
        Map<String, Object> map = new HashMap<>();

        map.put("userId", userId);
        map.put("userName", userRequest.getUserName());
        map.put("userImageUrl", userRequest.getUserImageUrl());
        map.put("userDescription", userRequest.getUserDescription());
        map.put("lastModifiedDate", new Date());

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void deleteUser(Integer userId) {
        String sql = "DELETE FROM user WHERE user_id = :userId";

        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);

        namedParameterJdbcTemplate.update(sql, map);
    }
}
