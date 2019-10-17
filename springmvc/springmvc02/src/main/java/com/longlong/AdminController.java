package com.longlong;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    /**
     * 窄化请求
     * 限定请求路径，方法的请求路径是类上的 @RequestMapping + 方法上的 @RequestMapping
     */
    @RequestMapping("/add/order")
    public ModelAndView order(){
        return new ModelAndView("order");
    }

    @RequestMapping("/delete/order")
    public ModelAndView order2(){
        return new ModelAndView("order");
    }

    /**
     * 方法返回值为字符串
     * 如果确实要返回一个字符串，那么方法必须添加 @ResponseBody
     */
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "hello";
    }

    /**
     * 如果返回的是一个逻辑视图名，则不用添加 @ResponseBody
     *
     * 此时可以通过 Mode 参数设置数据
     */
    @RequestMapping("/test2")
    public String test2(Model model){
        model.addAttribute("username","张三");
        return "hello";
    }

    /**
     * 服务端跳转
     * @return
     */
    @RequestMapping("/test3")
    public String test3(){
        return "forward:/WEB-INF/jsp/order.jsp";
    }

    @RequestMapping("/test4")
    public String test4(){
        return "redirect:/book";
    }
}
