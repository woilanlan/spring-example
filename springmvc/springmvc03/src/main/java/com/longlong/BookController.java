package com.longlong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BookController {
    @GetMapping("/addBook")
    public String addBook(){
        return "add-book";
    }

    /**
     * 对象参数
     *
     * 要将浏览器传来的日期字符串转换为日期对象，可以自定义日期转换类：DateConverter
     * 定义完成后，在XML中进行配置
     *
     * @param book
     */
    @PostMapping("/add")
    @ResponseBody
    public void add(Book book){
        System.out.println(book);
    }
}
