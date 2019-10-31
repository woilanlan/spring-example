package com.longlong;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

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

    @Test
    public void test4(){
        /*
        SqlSession 接口
        DefaultSqlSession 实现类
        调用 Configuration 的 getMapper 方法
        调用 MapperRegistry 的 getMapper 方法
        mapperProxyFactory.newInstance(sqlSession)
        通过java动态代理，自动提供了 UserMapper 的实现类
         */
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("王五");
        user.setAge(66);
        user.setAddress("郑州");
        int i = userMapper.addUser(user);
        System.out.println(i);
    }
}
