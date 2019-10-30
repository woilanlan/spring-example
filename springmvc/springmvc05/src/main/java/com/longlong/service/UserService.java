package com.longlong.service;

import com.longlong.bean.User;
import com.longlong.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public List<User> getAllUser(){
        return userDao.getAllUser();
    }
}
