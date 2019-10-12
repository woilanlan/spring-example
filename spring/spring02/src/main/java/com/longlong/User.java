package com.longlong;

public class User {
    private Integer id;
    private String name;
    private String address;

    public void sayHello(String name){
        System.out.println("hello:"+name);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
