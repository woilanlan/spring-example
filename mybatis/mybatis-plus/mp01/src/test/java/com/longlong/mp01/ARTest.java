package com.longlong.mp01;

import com.longlong.mp01.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ARTest {

    @Test
    public void insert(){
        User user = new User();
        user.setName("影流之主");
        user.setAge(20);
        user.setEmail("ylzz@gmail.com");
        user.setCreateTime(LocalDateTime.now());
        boolean insert = user.insert();
        System.out.println(insert);
    }

    /*
    返回一个新对象
     */
    @Test
    public void selectById(){
        User user = new User();
        User userSelect = user.selectById(1197769144726786049L);
        System.out.println(userSelect == user);
        System.out.println(userSelect);
    }

    @Test
    public void selectById2(){
        User user = new User();
        user.setId(1197769144726786049L);
        User userSelect = user.selectById();
        System.out.println(userSelect == user);
        System.out.println(userSelect);
    }

    /*
    更新
     */
    @Test
    public void updateById(){
        User user = new User();
        user.setId(1197769144726786049L);
        user.setName("小飞飞");
        user.setEmail("xff@gmail.com");
        boolean update = user.updateById();
        System.out.println(update);
    }

    /*
    删除
    注意：删除不存在的逻辑上属于成功
     */
    @Test
    public void deleteById(){
        User user = new User();
        user.setId(1197769144726786049L);
        boolean delete = user.deleteById();
        System.out.println(delete);
    }

    /*
    设置id后，
    会先进行查询，如果查询有记录，则执行更新
    否则则进行插入操作，id使用你设置的值
     */
    @Test
    public void insertOrUpdate(){
        User user = new User();
        user.setId(119777808117797683L);
        user.setName("小飞飞");
        boolean insertOrUpdate = user.insertOrUpdate();
        System.out.println(insertOrUpdate);
    }


}
