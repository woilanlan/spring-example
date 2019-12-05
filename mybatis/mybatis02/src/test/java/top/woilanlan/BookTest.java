package top.woilanlan;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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

    @org.junit.Test
    public void test2(){
//        List<Book> bookList = bookMapper.getBookByAuthor(null);
        List<Book> bookList = bookMapper.getBookByAuthor("吴承恩");
        System.out.println(bookList);
    }

    @Test
    public void test3(){
        List<Book> list = bookMapper.getBookByAuthor2("吴承恩", null);
        System.out.println(list);
        List<Book> list1 = bookMapper.getBookByAuthor2(null, 2);
        System.out.println(list1);
        List<Book> list2 = bookMapper.getBookByAuthor2("吴承恩", 2);
        System.out.println(list2);
    }

    @Test
    public void test4(){
        List<Book> list = bookMapper.getBooksByIds(new Integer[]{1, 2, 3});
        System.out.println(list);
    }

    @Test
    public void test5(){
        List<Book> books = new ArrayList<Book>();
        Book b1 = new Book();
        b1.setAuthor("曹雪芹");
        b1.setName("红楼梦");
        books.add(b1);
        Book b2 = new Book();
        b2.setAuthor("施耐庵");
        b2.setName("水浒传");
        books.add(b2);
        int i = bookMapper.addBook(books);
        System.out.println(i);
    }
}
