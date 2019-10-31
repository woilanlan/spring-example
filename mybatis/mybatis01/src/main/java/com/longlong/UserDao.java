package com.longlong;

import org.apache.ibatis.session.SqlSession;

/**
 * 此时可以发现 UserDao 这个类和 UserDao.xml 文件有很强的关联性
 *
 * 1、名字是一样的
 * 2、SqlSession 是模板代码
 * 3、方法名和 UserDao.xml 中定义的 SQL 片段的 id 一致
 * 4、具体执行方法和 SQL 片段的 XML 标签一致。
 *
 * 有这么多的一致性，可以推断，如果只给定 UserDao.xml 配置文件，就可以自动生成 UserDao 这个类
 *
 */
public class UserDao {
    SqlSession sqlSession = DBUtils.getInstance().openSession();

    public void addUser(User user){
        /*User user = new User();
        user.setName("张三");
        user.setAge(99);
        user.setAddress("洛阳");*/
        int insert = sqlSession.insert("UserDao.addUser", user);
        System.out.println(insert);
    }

    public void updateUserById(User user){
        int update = sqlSession.update("UserDao.updateUserById", user);
        System.out.println(update);
    }

    public void deleteUserById(Integer id){
        int delete = sqlSession.delete("UserDao.deleteUserById", id);
        System.out.println(delete);
    }

    public void getUserById(Integer id){
        User user = (User) sqlSession.selectOne("UserDao.getUserById", id);
        System.out.println(user);
    }
}
