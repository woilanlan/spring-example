package com.longlong.mp01;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.longlong.mp01.bean.User;
import com.longlong.mp01.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void getOne(){
        User one = userService.getOne(Wrappers.<User>lambdaQuery().gt(User::getAge, 18), false);
        System.out.println(one);
    }

    @Test
    public void Batch(){
        User user1 = new User();
        user1.setName("徐丽");
        user1.setAge(28);

        User user2 = new User();
        user2.setName("徐丽2");
        user2.setAge(28);
        List<User> userList = Arrays.asList(user1, user2);
        boolean saveBatch = userService.saveBatch(userList);
        System.out.println(saveBatch);
    }

    @Test
    public void Batch2(){
        User user1 = new User();
        user1.setName("徐丽");
        user1.setAge(28);

        User user2 = new User();
        user2.setId(1198601086420996097L);
        user2.setName("徐力");
        user2.setAge(30);
        List<User> userList = Arrays.asList(user1, user2);
        boolean saveBatch = userService.saveOrUpdateBatch(userList);
        System.out.println(saveBatch);
    }

    @Test
    public void chain(){
        List<User> userList = userService.lambdaQuery().gt(User::getAge, 20).like(User::getName, "羽").list();
        userList.forEach(System.out::println);
    }

    @Test
    public void chain1(){
        boolean update = userService.lambdaUpdate().eq(User::getAge, 28).set(User::getAge, 26).update();
        System.out.println(update);
    }

    @Test
    public void chain2(){
        boolean remove = userService.lambdaUpdate().eq(User::getId, 1198601846433038337L).remove();
        System.out.println(remove);
    }
}
