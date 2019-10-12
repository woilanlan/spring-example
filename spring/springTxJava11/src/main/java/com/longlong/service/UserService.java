package com.longlong.service;

import com.longlong.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Transactional
    public void transferMoney(){
        userDao.addMoney();
        int i = 1/0;
        userDao.minMoney();
    }
}
