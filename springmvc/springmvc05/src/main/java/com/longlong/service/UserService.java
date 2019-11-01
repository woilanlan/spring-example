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

    public List<User> getAllUser(Integer page, Integer count) {
        return userDao.getAllUser((page-1)*count,count);
    }

    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    public int addUser(User user) {
        return userDao.addUser(user);
    }

    public int deleteUserById(Integer id) {
        return userDao.deleteUserById(id);
    }

    public int updateUserById(User user) {
        return userDao.updateUserById(user);
    }
}
