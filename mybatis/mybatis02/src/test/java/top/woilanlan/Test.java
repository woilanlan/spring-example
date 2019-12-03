package top.woilanlan;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import top.woilanlan.bean.User;
import top.woilanlan.bean.UserWrapper;
import top.woilanlan.mapper.UserMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {
    private SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        sqlSession = DBUtils.getInstance().openSession();
    }

    @After
    public void after(){
        sqlSession.commit();
        sqlSession.close();
    }

    @org.junit.Test
    public void test1(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);
        System.out.println(user);
    }

    @org.junit.Test
    public void test2(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Long count = userMapper.getCount();
        System.out.println(count);
    }

    @org.junit.Test
    public void test3(){
        List<String> aa = new ArrayList<String>();
        aa.add("aa");
        aa.add("bb");
        User user = new User();
        user.setAddress("广州");
        user.setAge(99);
        user.setFavorites(aa);
        user.setName("诸葛");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.addUser(user);
        System.out.println(i);
    }

    @org.junit.Test
    public void test4(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.getUsersByPage(0, 5);
        System.out.println(users);
    }

    @org.junit.Test
    public void test5(){
        List<String> aa = new ArrayList<String>();
        aa.add("aa");
        aa.add("bb");
        User user = new User();
        user.setAddress("惠州");
        user.setAge(99);
        user.setFavorites(aa);
        user.setName("张飞");
        UserWrapper uw = new UserWrapper();
        uw.setUser(user);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.addUser2(uw);
        System.out.println(i);
    }

    @org.junit.Test
    public void test6(){
        List<String> aa = new ArrayList<String>();
        aa.add("aa");
        aa.add("bb");
        User user = new User();
        user.setAddress("惠州");
        user.setAge(99);
        user.setFavorites(aa);
        user.setName("张飞");
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("name","关羽");
        map.put("address","上海");
        map.put("favorites",aa);

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.addUser3(map);
        System.out.println(i);
    }

}
