package com.longlong;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class Book {

    @Length(min = 3,message = "{book.name.length}")
    private String name;    //书名长度必须大于3
    @NotNull(message = "{book.author.null}")
    private String author;  //作者不能为空

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
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
