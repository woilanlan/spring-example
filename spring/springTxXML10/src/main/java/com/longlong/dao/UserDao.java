package com.longlong.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

public class UserDao {

    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addMoney(){
        jdbcTemplate.update("update account set money = money+100 where name = ?;","zhangsan");
    }

    public void minMoney(){
        jdbcTemplate.update("update account set money = money-100 where name = ?;","lisi");
    }
}
