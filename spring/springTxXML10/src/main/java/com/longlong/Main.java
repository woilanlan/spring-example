package com.longlong;

import com.longlong.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 配置声明式事务
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService bean = ctx.getBean(UserService.class);
        bean.updateMoney();
    }
}
