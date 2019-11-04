package com.longlong.mp01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.longlong.mp01.dao")
@SpringBootApplication
public class MP01Application {

    public static void main(String[] args) {
        SpringApplication.run(MP01Application.class, args);
    }

}
