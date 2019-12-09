package top.woilanlan.mapper;

import org.apache.ibatis.annotations.Param;
import top.woilanlan.bean.Book;

import java.util.List;

public interface BookMapper {
    List<Book> getAllBook();

    List<Book> getBookByAuthor(String author);

    /*
    如果author和id都为null,则返回所有数据
    如果author不为null,按照author查询
    如果id不为null,查询大于id的所有数据
     */
    List<Book> getBookByAuthor2(@Param("author") String author,@Param("id") Integer id);

    /*
    数组参数，如果不加@Paraw注解，默认名字为array
     */
    List<Book> getBooksByIds(@Param("ids") Integer[] ids);

    int addBook(@Param("books") List<Book> books);

    int updateBookById(Book book);

    int insertBook(Book book);
}
