package com.longlong.service;

import com.longlong.dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Transactional
 * 加在类上表示，表示类中所有的方法都有事务
 * 加载方法上，表示只有某一个方法有事务
 */
public class UserService {

    UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void updateMoney(){
        userDao.addMoney();
        int i = 1/0;
        userDao.minMoney();
    }
}
