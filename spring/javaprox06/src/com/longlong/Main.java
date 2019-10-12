package com.longlong;

public class Main {
    public static void main(String[] args) {
        //获取代理对象
        Calculator instance = (Calculator) new MyProxy().getInstance(new CalculatorImpl());
//        System.out.println(instance.add(9,8));
        instance.add(9,8);
        instance.min(9,8);
    }
}
