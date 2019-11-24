package com.longlong.mp01.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.longlong.mp01.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends IService<User> {
    List<User> getAllUser(Integer page, Integer count);

    int addUser(User user);

    User getUserById(Integer id);
}
