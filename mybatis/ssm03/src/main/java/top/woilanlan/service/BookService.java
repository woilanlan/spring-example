package top.woilanlan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.woilanlan.bean.Book;
import top.woilanlan.dao.BookMapper;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookMapper bookMapper;

    public List<Book> getAllBooks(){
        return bookMapper.getAllBooks();
    }
}
