package com.longlong.mp01;

import com.longlong.mp01.bean.User;
import com.longlong.mp01.dao.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    /*
    查询所有
     */
    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    /*
    新增
    日志打印：
    Preparing: INSERT INTO user ( id, create_time, name, email, age ) VALUES ( ?, ?, ?, ?, ? )
    Parameters: 1191293641610248193(Long), 2019-11-04T17:58:31.389(LocalDateTime), 花木兰(String), hml@gmail.com(String), 20(Integer)

    user：对应实体类的驼峰写法
    id：采用雪花算法的自增id,主键默认查找 id
    create_time：对应实体类属性的驼峰写法
     */
    @Test
    public void insert(){
        User user = new User();
        user.setRealName("项羽");
        user.setAge(20);
        user.setEmail("xy@gmail.com");
        user.setCreateTime(LocalDateTime.now());
        int rows = userMapper.insert(user);
        System.out.println("影响记录数："+ rows);
    }
}
