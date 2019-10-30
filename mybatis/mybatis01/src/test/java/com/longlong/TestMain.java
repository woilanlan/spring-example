package com.longlong;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestMain {

    private SqlSession sqlSession;

    @Before
    public void before() throws IOException {
/*
        //加载配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-conf.xml");
        //根据配置文件获取一个sqlSessionFactory对象，这个对象相当于连接工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //获取一个sqlSession，类似于之前学过的Connection
        sqlSession = sqlSessionFactory.openSession();
*/
        sqlSession = DBUtils.getInstance().openSession();
    }

    @After
    public void after(){
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test1(){
        User user = new User();
        user.setId(3);
        user.setName("李四");
        int update = sqlSession.update("UserDao.updateUserById", user);
        System.out.println(update);
    }

    @Test
    public void test2(){
        int delete = sqlSession.delete("UserDao.deleteUserById", 2);
        System.out.println(delete);
    }

    @Test
    public void test3(){
        User user = (User) sqlSession.selectOne("UserDao.getUserById", 3);
        System.out.println(user);
    }
}
