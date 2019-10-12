package com.longlong;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        //m.test1();
        m.test2();
    }

    public void test1(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        MyCalculator myCalculator = (MyCalculator) ctx.getBean("myCalculator");
        myCalculator.add(8,9);
        myCalculator.sayHello("小明");
        myCalculator.min(8,9);
    }

    public void test2(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyCalculator myCalculator = (MyCalculator) ctx.getBean("myCalculator");
        myCalculator.add(8,7);
    }
}
