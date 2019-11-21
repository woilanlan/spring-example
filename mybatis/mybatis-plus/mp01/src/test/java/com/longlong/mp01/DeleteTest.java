package com.longlong.mp01;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.longlong.mp01.bean.User;
import com.longlong.mp01.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeleteTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void deleteById(){
        int rows = userMapper.deleteById(1197512949365668353L);
        System.out.println("删除条数："+rows);
    }

    @Test
    public void deleteByMap(){
        Map<String,Object> columnMap = new HashMap<>();
        columnMap.put("name","关羽2");
        columnMap.put("age",30);
        int rows = userMapper.deleteByMap(columnMap);
        System.out.println("删除条数："+rows);
    }

    @Test
    public void deleteBatchIds(){
        int rows = userMapper.deleteBatchIds(Arrays.asList(1197512941365668353L,1197512942365668353L,
                1197512943365668353L));
        System.out.println("删除条数："+rows);
    }

    @Test
    public void deleteByWrapper(){
        LambdaQueryWrapper<User> lambdaQuery = Wrappers.<User>lambdaQuery();
        lambdaQuery.eq(User::getAge,31).or().gt(User::getAge,41);
        int rows = userMapper.delete(lambdaQuery);
        System.out.println("删除条数："+rows);
    }
}
