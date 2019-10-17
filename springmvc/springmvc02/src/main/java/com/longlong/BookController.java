package com.longlong;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Controller 表示该类是一个后端处理器
 */
@Controller
public class BookController {

    @RequestMapping(value = {"/index","/"})
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    /**
     * @RequestMapping 路径映射
     * 默认既可以处理get请求，也可以处理post请求
     * 通过method属性手动设置该方法可以处理的http请求
     */
    @RequestMapping(value = "/book",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView getAllBook(){
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
        mv.setViewName("book");
        return mv;
    }

    /**
     * 返回值为void时，方法中可以不用做任何返回
     * 在浏览器端请求 /test1 接口，springmvc会默认去查找方法同名的页面作为方法的视图返回。
     * 如果确实不需要该方法返回页面，可以使用 @ResponseBody 注解。
     *
     * 可以将方法完全当成一个 servlet 中的 doGet 或者 doPost 对待,直接利用 HttpServletResponse 写出数据
     */
    @RequestMapping("/test1")
    @ResponseBody
    public void test1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        PrintWriter out = resp.getWriter();
        out.write(name);
        out.flush();
        out.close();
        System.out.println("test1");
    }

    /**
     * 也可以利用 HttpServletRequest 实现服务器端跳转
     */
    @RequestMapping("/test2")
    @ResponseBody
    public void test2(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //请求转发
//        req.getRequestDispatcher("/WEB-INF/jsp/order.jsp").forward(req,resp);

        //重定向，方式1
//        resp.sendRedirect("/springmvc02/book");

        //重定向，方式2
        resp.setStatus(302);
        resp.setHeader("Location","/springmvc02/book");
    }

    /**
     *  jackson,gson,fastjson
     * 返回json数据:
     */
    @RequestMapping("/test3")
    @ResponseBody
    public void test3(HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();

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

        String s = new Gson().toJson(books);

        out.write(s);
        out.flush();
        out.close();
    }
}
