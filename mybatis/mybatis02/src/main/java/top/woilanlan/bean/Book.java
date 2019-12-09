package top.woilanlan.bean;

import org.apache.ibatis.annotations.Param;

public class Book {
    private Integer id;
    private String author;
    private String name;
    private Double price;

    public Book() {
    }

    public Book(@Param("id") Integer id, @Param("author") String author) {
        this.id = id;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
