package com.longlong;

import com.mysql.cj.jdbc.Driver;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Test2 {

    private JdbcTemplate jdbcTemplate;

    @Before
    public void before(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        //ds.setDriverClassName(Driver.class.getName());
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUsername("root");
        ds.setPassword("Longlong");
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&useSSL=false&useUnicode=true&serverTimezone=UTC");
        jdbcTemplate = new JdbcTemplate(ds);
    }

    @Test
    public void test1(){
        int update = jdbcTemplate.update("insert into t_book (name,author) values (?,?) ;", "西游记", "吴承恩");
        System.out.println(update);
    }

    @Test
    public void test2(){
        int i = jdbcTemplate.update("update t_book set name = ? where id = ? ;", "三国演义", 1);
        System.out.println(i);
    }

    @Test
    public void test3(){
        int update = jdbcTemplate.update("delete from t_book where id = ? ", 3);
        System.out.println(update);
    }

    @Test
    public void test4(){
        List<Book> list = jdbcTemplate.query("select * from t_book where id > ?", new RowMapper<Book>() {
            public Book mapRow(ResultSet resultSet, int i) throws SQLException {
                Book book = new Book();
                book.setName(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("author"));
                book.setId(resultSet.getInt("id"));

                Author au = new Author();
                au.setName(resultSet.getString("author"));
                book.setAu(au);

                return book;
            }
        }, 2);
        System.out.println(list);
    }

    @Test
    public void test5(){
        //列名和属性名一一对应
        List<Book> list = jdbcTemplate.query("select * from t_book where id > ?", new BeanPropertyRowMapper<Book>(Book.class),2);
        System.out.println(list);
    }
}
