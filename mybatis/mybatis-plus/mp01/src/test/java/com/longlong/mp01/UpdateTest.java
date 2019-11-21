package com.longlong.mp01;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.additional.update.impl.LambdaUpdateChainWrapper;
import com.longlong.mp01.bean.User;
import com.longlong.mp01.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdateTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void updateById(){
        User user = new User();
        user.setId(1197512441370796033L);
        user.setAge(26);
        user.setEmail("bmd@gmail.com");
        int rows = userMapper.updateById(user);
        System.out.println("影响记录数"+rows);
    }

    @Test
    public void updateByWrapper(){
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name","关羽").eq("age",30);
        User user = new User();
        user.setEmail("bmd@gmail.com");
        user.setAge(31);
        int rows = userMapper.update(user,updateWrapper);
        System.out.println("影响记录数"+rows);
    }

    @Test
    public void updateByWrapper1(){
        User whereUser = new User();
        whereUser.setName("关羽");
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>(whereUser);
        //updateWrapper.eq("name","关羽").eq("age",30);

        User user = new User();
        user.setEmail("bmd@gmail.com");
        user.setAge(30);
        int rows = userMapper.update(user,updateWrapper);
        System.out.println("影响记录数"+rows);
    }

    /*
    更新少量字段
    使用set直接设置值
     */
    @Test
    public void updateByWrapper2(){
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name","关羽").eq("age",30)
                .set("age",31);
        int rows = userMapper.update(null,updateWrapper);
        System.out.println("影响记录数"+rows);
    }

    /*
    防误写
     */
    @Test
    public void updateByWrapperLambda(){
        LambdaUpdateWrapper<User> lambdaUpdate = Wrappers.<User>lambdaUpdate();
        lambdaUpdate.eq(User::getName,"关羽").eq(User::getAge,31).set(User::getAge,29);
        int rows = userMapper.update(null,lambdaUpdate);
        System.out.println("影响记录数"+rows);
    }

    /*
    链式操作
     */
    @Test
    public void updateByWrapperLambdaChain(){
        boolean update = new LambdaUpdateChainWrapper<User>(userMapper)
                .eq(User::getName, "关羽").eq(User::getAge, 29).set(User::getAge, 30)
                .update();
        System.out.println(update);
    }
}
