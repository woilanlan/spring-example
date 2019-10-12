package com.longlong.bean;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("p1")
public class Person {
    public void sayHello(String name){
        System.out.println("Hello,"+name+"!");
    }
}
