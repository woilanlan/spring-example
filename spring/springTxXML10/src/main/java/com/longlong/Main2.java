package com.longlong;

import com.longlong.config.JavaConfig;
import com.longlong.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        UserService userService = ctx.getBean(UserService.class);
        userService.updateMoney();
    }
}
