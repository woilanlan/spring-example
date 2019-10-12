package com.longlong;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class BookController implements Controller {

    /**
     * 处理具体请求
     * @param httpServletRequest
     * @param httpServletResponse
     * @return 模型和视图（数据+页面）
     * @throws Exception
     */
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Book> books = new ArrayList<Book>();
        Book b1 = new Book();
        b1.setId(1);
        b1.setName("三国演义");
        b1.setAuthor("罗贯中");
        books.add(b1);
        Book b2 = new Book();
        b2.setId(2);
        b2.setName("西游记");
        b2.setAuthor("吴承恩");
        books.add(b2);
        mv.addObject("bs",books);

        //当更换页面模板或者调整路径，这里也需要修改
        //mv.setViewName("/WEB-INF/jsp/book.jsp");

        // 指定视图名称，路径和后缀通过配置来设定
        mv.setViewName("book");
        return mv;
    }
}
