package com.longlong;

import com.longlong.config.JavaConfig;
import com.longlong.service.UserService;
import com.longlong.service.UserService2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        UserService userService = ctx.getBean(UserService.class);
        userService.transferMoney();

        UserService2 userService2 = ctx.getBean(UserService2.class);
        userService2.transferMoney();
    }
}
