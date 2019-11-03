package com.longlong.controller;

import com.longlong.bean.RespBean;
import com.longlong.bean.User;
import com.longlong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
@RestController实际上是一个组合注解，是@Controller和@ResponseBody的组合

这个接口中，主要定义User的增删改查
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    /*
    查询所有、分页查询、条件查询
    一般都是直接使用资源的复数形式来做路径
     */
    @GetMapping("/users")
    public List<User> getAllUser(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "5") Integer count){
        System.out.println("getAllUser");
        return userService.getAllUser(page,count);
    }

    /*
    按照id查询，例如：http://localhost:8080/user/1
    表示查询id为1的用户
    @PathVariable 表示这个变量是路径里的一个变量
     */
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    /**
     * 使用POST请求来完成添加功能
     * {"name":"张三","age":"89","address":"luoyang"}
     * @param user
     * @return
     */
    @PostMapping("/user")
    public RespBean addUser(@RequestBody User user){
        int result = userService.addUser(user);
        if(result == 1){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @DeleteMapping("/user/{id}")
    public RespBean deleteUserById(@PathVariable Integer id){
        int result = userService.deleteUserById(id);
        if(result == 1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    /*
    {"name":"李四","age":"89","address":"luoyang","id":"10"}
     */
    @PutMapping("/user")
    public RespBean updateUserById(@RequestBody User user){
        int result = userService.updateUserById(user);
        if(result == 1){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }
}
