package com.longlong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    //@RequestMapping(value = "/doReg",method = {RequestMethod.POST})
    @PostMapping("/doReg")
    public String doReg(String username,String password){
        System.out.println(username+">>>"+password);
        return "redirect:/login";
    }
}
