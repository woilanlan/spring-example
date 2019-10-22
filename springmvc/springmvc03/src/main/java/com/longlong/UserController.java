package com.longlong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    @RequestMapping("/reg")
    public String reg(){
        return "reg";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 参数为：java基本数据类型+String
     * 使用基本数据类型时，参数的名称必须和浏览器传来的参数key一致，这样才能实现自动映射
     *
     * @RequestMapping(value = "/doReg",method = {RequestMethod.POST})
     * 简单写为 @PostMapping("/doReg")
     *
     * 如果参数名和浏览器传来的key不一致，可以通过@RequestParam("password")来解决
     * 添加了 @RequestParam 注解后，对应的参数将默认成为必填参数，如果没有传递相关的参数，则会抛出异常
     * 如果不是必填参数，需要明确指定
     * 1、设置 required 属性 @RequestParam(value = "password",required = false)
     * 2、设置 defaultValue 属性，指定默认值
     */
    @PostMapping("/doReg")
    public String doReg(String username,@RequestParam(value = "password",required = false,defaultValue = "111") String pwd){
        System.out.println(username+">>>"+pwd);
        return "redirect:/login";
    }
}
