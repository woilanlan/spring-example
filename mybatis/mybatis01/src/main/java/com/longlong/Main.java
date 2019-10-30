package com.longlong;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        //加载配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-conf.xml");
        //根据配置文件获取一个sqlSessionFactory对象，这个对象相当于连接工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //获取一个sqlSession，类似于之前学过的Connection
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行SQL，但是SQL是提前在xml文件中定义好的
        User user = new User();
        user.setName("张三");
        user.setAge(99);
        user.setAddress("洛阳");
        int insert = sqlSession.insert("UserDao.addUser", user);
        System.out.println(insert);
        sqlSession.commit();
        sqlSession.close();
    }
}
