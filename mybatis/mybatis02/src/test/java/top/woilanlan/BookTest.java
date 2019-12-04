package top.woilanlan;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import top.woilanlan.bean.Book;
import top.woilanlan.bean.User;
import top.woilanlan.bean.UserWrapper;
import top.woilanlan.mapper.BookMapper;
import top.woilanlan.mapper.UserMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookTest {
    private SqlSession sqlSession;
    private BookMapper bookMapper;

    @Before
    public void before() throws IOException {
        sqlSession = DBUtils.getInstance().openSession();
        bookMapper = sqlSession.getMapper(BookMapper.class);
    }

    @After
    public void after(){
        sqlSession.commit();
        sqlSession.close();
    }

    @org.junit.Test
    public void test1(){
        List<Book> allBook = bookMapper.getAllBook();
        System.out.println(allBook);
    }
}
