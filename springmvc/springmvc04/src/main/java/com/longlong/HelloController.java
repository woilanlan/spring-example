package com.longlong;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping("/")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    /*
    数据回显
    默认方式类似于Servlet中的方式
    在接口中返回相关数据，在表单中填入接口中返回的数据
    */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(String username, String password, Model model){
        if("zhangsan".equals(username) && "123".equals(password)){
            return "index";
        }
        model.addAttribute("username",username);
        model.addAttribute("password",password);
        return "forward:/login";
    }

    /*
    使用对象接收，默认就会把这个对象放到model中去，在前端页面可以直接使用对象中的数据
    表单中对象的名字和参数的名字是一致的，不可以改变。
    如果两个名字不一致，可以使用注解 @ModelAttribute 来解决
    */
    @RequestMapping("/login1")
    public String login1(){
        return "login1";
    }

/*    @PostMapping("/doLogin1")
    public String doLogin1(User user){
        if("zhangsan".equals(user.getUsername()) && "123".equals(user.getPassword())){
            return "index";
        }
        return "forward:/login1";
    }*/

    /*
    注解 @ModelAttribute
    1、修改参数回显变量名
    @ModelAttribute("use") 表单中就可以使用 use去访问 User对象中的数据
    2、配置全局响应值
    在当前Controller中，接口中的每一个方法都返回一个集合。
    @ModelAttribute("as") 其中的 as 就是返回数据的 key
     */
    @PostMapping("/doLogin1")
    public String doLogin1(@ModelAttribute("use") User user){
        if("zhangsan".equals(user.getUsername()) && "123".equals(user.getPassword())){
            return "index";
        }
        //return "forward:/login1";
        return "login1";
    }

    @ModelAttribute("as")
    public List<String> getAllAddress(){
        List<String> as = new ArrayList<String>();
        as.add("深圳");
        as.add("上海");
        as.add("广州");
        as.add("北京");
        return as;
    }
}
