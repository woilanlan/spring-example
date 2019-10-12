package com.longlong;

public class CalculatorImpl implements Calculator {
    @Override
    public int add(int a, int b) {
        System.out.println(a+"+"+b+"="+(a+b));
        return a+b;
    }

    @Override
    public void min(int a, int b) {
        System.out.println(a+"-"+b+"="+(a-b));
    }
}
