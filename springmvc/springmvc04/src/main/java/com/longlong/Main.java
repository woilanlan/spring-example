package com.longlong;

public class Main {
    public static void main(String[] args) {
        //出现内存溢出的错误：OutOfMemoryError
        int[] ints = new int[Integer.MAX_VALUE];
    }
}
