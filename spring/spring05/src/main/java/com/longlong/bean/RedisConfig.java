package com.longlong.bean;

public class RedisConfig {
    private String url;
    private String password;

    public RedisConfig() {
    }

    public RedisConfig(String url, String password) {
        this.url = url;
        this.password = password;
    }

    @Override
    public String toString() {
        return "RedisConfig{" +
                "url='" + url + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
