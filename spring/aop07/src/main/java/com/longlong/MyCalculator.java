package com.longlong;

import org.springframework.stereotype.Component;

import javax.xml.ws.Action;

@Component
public class MyCalculator {
    //@MyAction
    public int add(int a,int b){
        //int i = 1/0;
        System.out.println(a+"+"+b+"="+(a+b));
        return a+b;
    }

    //@MyAction
    public String sayHello(String name){
        return "hello "+name+" !";
    }

    //@MyAction
    public void min(int a,int b){

    }
}
