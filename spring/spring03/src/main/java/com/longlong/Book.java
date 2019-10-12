package com.longlong;

public class Book {
    private Integer id;
    private String name;
    private String author;

    public Book() {
        System.out.println("无参构造方法");
    }

    public Book(Integer id, String name, String author) {
        System.out.println("id>"+id+",name>"+name+",author>"+author);
        this.id = id;
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        System.out.println("set方法"+id);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
