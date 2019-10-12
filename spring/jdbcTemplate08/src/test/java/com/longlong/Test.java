package com.longlong;

import org.junit.Before;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Test {

    JdbcTemplate jdbcTemplate;

    BookService bookService;

    @Before
    public void before(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        jdbcTemplate = (JdbcTemplate) ctx.getBean(JdbcTemplate.class);
        bookService = ctx.getBean(BookService.class);
    }

    @org.junit.Test
    public void test1(){
        List<Book> list = jdbcTemplate.query("select * from t_book", new BeanPropertyRowMapper(Book.class));
        System.out.println(list);
    }

    @org.junit.Test
    public void test2(){
        bookService.getAllBooks();
    }
}
