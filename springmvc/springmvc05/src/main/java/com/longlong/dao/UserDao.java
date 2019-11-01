package com.longlong.dao;

import com.longlong.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getAllUser(){
        return jdbcTemplate.query("select * from user",new BeanPropertyRowMapper<User>(User.class));
    }

    public List<User> getAllUser(int Start, Integer count) {
        return null;
    }

    public int addUser(User user) {
    }

    public User getUserById(Integer id) {
    }

    public int updateUserById(User user) {
    }

    public int deleteUserById(Integer id) {
    }
}
