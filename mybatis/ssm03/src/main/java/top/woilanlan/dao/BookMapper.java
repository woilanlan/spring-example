package top.woilanlan.dao;

import top.woilanlan.bean.Book;

import java.util.List;

/*
@Repository 会调用类构造方法初始化，这里是一个接口。
MyBatis 使用动态代理来实现
 */
public interface BookMapper {
    List<Book> getAllBooks();
}
