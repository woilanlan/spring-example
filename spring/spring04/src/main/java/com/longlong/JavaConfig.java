package com.longlong;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 这是一个Java配置类，它的作用类似于applicationContext.xml文件
 */
@Configuration
public class JavaConfig {
    /**
     * 返回一个JavaBean的方法，就类似于applicationContext.xml中的一个Bean标签
     * <bean id="book1" class="com.longlong.Book">
     *
     * 默认情况下，id就是方法名,可以通过@Bean注解的name或者value属性自定义方法名
     * @return
     */
    @Bean(name = "b1")
    Book book(){
        return new Book();
    }

}
