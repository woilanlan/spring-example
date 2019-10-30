package com.longlong.controller;

import com.longlong.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    @ResponseBody
    public String  hello(){
        return helloService.hello();
    }
}
