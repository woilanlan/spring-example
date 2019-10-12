package com.longlong;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class User {
    private Integer id;
    private String name;
    private String address;
    private Cat cat;
    private List<String> favorites;
    private Book[] books;
    private Map<String,Object> info;
    private Properties props;

    public User() {
    }

    public User(Integer id, String name, String address, Cat cat) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", cat=" + cat +
                ", favorites=" + favorites +
                ", books=" + Arrays.toString(books) +
                ", info=" + info +
                ", props=" + props +
                '}';
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

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public List<String> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<String> favorites) {
        this.favorites = favorites;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public Map<String, Object> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Object> info) {
        this.info = info;
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }
}
