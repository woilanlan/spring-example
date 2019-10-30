package com.longlong.dao;

import org.springframework.stereotype.Repository;

@Repository
public class HelloDao {

    public String hello(){
        return "HelloDao";
    }
}
