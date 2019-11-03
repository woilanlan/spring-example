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

    public List<User> getAllUser(int start, Integer count) {
        return jdbcTemplate.query("select * from user limit ?,?",new BeanPropertyRowMapper<User>(User.class),start,count);
    }

    public int addUser(User user) {
        return jdbcTemplate.update("insert into user (name,age,address) values (?,?,?);",user.getName(),
                user.getAge(),user.getAddress());
    }

    public User getUserById(Integer id) {
        return jdbcTemplate.queryForObject("select * from user where id = ?",new BeanPropertyRowMapper<User>(User.class),id);
    }

    public int updateUserById(User user) {
        return jdbcTemplate.update("update user set name = ? where id = ?;",user.getName(),user.getId());
    }

    public int deleteUserById(Integer id) {
        return jdbcTemplate.update("delete from user where id = ?",id);
    }
}
