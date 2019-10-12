package com.longlong.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserDao {

    /**
     * @Autowired 自动注入，会去spring容器中，查找类型为JdbcTemplate的实例注入给该变量
     *
     * @Resource 按照名称去查找
     */
    //@Resource
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addMoney(){
        jdbcTemplate.update("update account set money = money+100 where name = ? ;","zhangsan");
    }

    public void minMoney(){
        jdbcTemplate.update("update account set money = money-100 where name = ? ;","lisi");
    }
}
