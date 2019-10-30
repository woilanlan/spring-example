package com.longlong;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/*
由于SqlSessionFactory在每个方法中都会用到，因此，可以将之封装成一个方法
 */
public class DBUtils {

    private static SqlSessionFactory sqlSessionFactory;

    //避免每次都加载，使用单例模式
    public static SqlSessionFactory getInstance() {
        if(sqlSessionFactory == null){
            InputStream is = null;
            try {
                is = Resources.getResourceAsStream("mybatis-conf.xml");
            } catch (IOException e) {
                e.printStackTrace();
            }
            synchronized (DBUtils.class) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            }
        }
        return sqlSessionFactory;
    }
}
