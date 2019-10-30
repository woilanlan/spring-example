package com.longlong.service;

import com.longlong.dao.HelloDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Autowired
    HelloDao helloDao;

    public String hello(){
        return helloDao.hello();
    }
}
