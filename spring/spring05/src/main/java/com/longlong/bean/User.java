package com.longlong.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Component注解表示该类是一个Bean,在项目启动时，该类会被自动扫描，然后实例化并注册到Spring容器中
 * 实例默认的名字就是类名首字母小写
 *
 * 类似的注解，Spring一共提供了四个：
 * 1、@Component，一般用在身份不明确的组件中
 * 2、@Service，一般用在Service层
 * 3、@Controller，一般用在控制层
 * 4、@Repository，一般用在数据库访问层
 *
 * 目前来说，这四个的功能基本一致，没有大的区别
 */

@Component
@Scope(value = "prototype")
public class User {
    private Integer id;
    private String name;
    private String address;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
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
}
