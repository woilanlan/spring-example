package com.longlong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 集合类型
 */
@Controller
public class UserController {

    @GetMapping("/reg")
    public String reg(){
        return "reg";
    }

//    直接使用数组接收参数
    @PostMapping("/doReg1")
    @ResponseBody
    public void doReg1(String username,String password,String[] favorites){
        System.out.println(username+">>>"+password+">>>"+ Arrays.toString(favorites));
    }

    /*
    这里的参数类型，只能使用数组，不能使用集合
    如果非要用集合，可以自定义参数类型转换
     */
    @PostMapping("/doReg2")
    @ResponseBody
    public void doReg2(String username, String password, ArrayList<String> favorites){
        System.out.println(username+">>>"+password+">>>"+ favorites);
    }

    /*
    如果想要使用集合去接收参数，也可以将集合放到一个包装类中，
    集合中可以放对象，此时表单的写法：books[0].name
     */
    @PostMapping("/doReg3")
    @ResponseBody
    public void doReg3(User user){
        System.out.println(user);
    }

    @PostMapping("/doReg")
    @ResponseBody
    public void doReg(String[] favorites){
        System.out.println(Arrays.toString(favorites));
    }
}
