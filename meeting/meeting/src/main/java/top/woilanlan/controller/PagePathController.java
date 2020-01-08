package top.woilanlan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import top.woilanlan.bean.Employee;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PagePathController {

    /*
    返回对应页面
     */
//    @GetMapping("/{path}")
//    public String path(@PathVariable String path){
//        return path;
//    }
//
//    @ModelAttribute("e")
//    public Employee loginUser(HttpServletRequest req){
//        return ((Employee) req.getSession().getAttribute("loginUser"));
//    }
}
