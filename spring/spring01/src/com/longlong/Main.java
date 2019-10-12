package com.longlong;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setName("zhangsan");
        Cat cat = new Cat();
        cat.setName("小白");
        cat.setColor("白色");
        user.setCat(cat);
        cat.setId(1000L);
        Long a = 1000L;
        if(cat.getId().equals(a)){
            System.out.println("可以判断");
        }else{
            System.out.println("不可以判断");
        }
    }
}
