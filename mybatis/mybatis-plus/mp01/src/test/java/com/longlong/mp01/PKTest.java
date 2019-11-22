package com.longlong.mp01;

import com.longlong.mp01.bean.User;
import com.longlong.mp01.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PKTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void insert(){
        User user = new User();
        user.setName("刘明");
        user.setAge(30);
        user.setEmail("gy@gmail.com");
        user.setCreateTime(LocalDateTime.now());
        int rows = userMapper.insert(user);
        System.out.println("影响记录数："+ rows);
        System.out.println("主键："+ user.getId());
    }
}
