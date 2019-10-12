package com.longlong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class BookService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void getAllBooks(){
        List<Book> list = jdbcTemplate.query("select * from t_book", new BeanPropertyRowMapper(Book.class));
        System.out.println(list);
    }
}
