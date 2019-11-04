package com.longlong.mp01.service.impl;

import com.longlong.mp01.bean.User;
import com.longlong.mp01.dao.UserMapper;
import com.longlong.mp01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser(Integer page, Integer count) {
        return userMapper.selectList(null);
    }

    @Override
    public int addUser(User user) {
        return 0;
    }

    @Override
    public User getUserById(Integer id) {
        return null;
    }
}
