package com.longlong.mp01.controller;

import com.longlong.mp01.bean.User;
import com.longlong.mp01.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "用户管理相关接口")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    @ApiOperation("查询所有用户的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",value = "页码",defaultValue = "1"),
            @ApiImplicitParam(name = "count",value = "每页显示几条",defaultValue = "5")
    })
    public List<User> getAllUser(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer count){
        System.out.println("getAllUser");
        return userService.getAllUser(page,count);
    }

    @GetMapping("/user/{id}")
    @ApiOperation("根据id查询用户的接口")
    @ApiImplicitParam(name = "id", value = "用户id", required = true)
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    @ApiOperation("新增用户的接口")
    public String addUser(@RequestBody User user) {
        int result = userService.addUser(user);
        return "添加成功";
    }
}
