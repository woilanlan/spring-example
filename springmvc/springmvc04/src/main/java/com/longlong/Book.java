package com.longlong;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/*
数据校验

普通校验

分组校验
一个实体类有10个字段，每个字段都添加了数据校验注解。在添加的时候，这些注解都有效，在更新时，可能只需要去校验实体类中某几个字段，就可以使用分组校验

校验注解
@Null 被注解的元素必须为 null
@NotNull 被注解的元素必须不为 null
@AssertTrue 被注解的元素必须为 true
@AssertFalse 被注解的元素必须为 false
@Min(value) 被注解的元素必须是一个数字，其值必须大于等于指定的最小值
@Max(value) 被注解的元素必须是一个数字，其值必须小于等于指定的最大值
@DecimalMin(value) 被注解的元素必须是一个数字，其值必须大于等于指定的最小值
@DecimalMax(value) 被注解的元素必须是一个数字，其值必须小于等于指定的最大值
@Size(max=, min=) 被注解的元素的大小必须在指定的范围内
@Digits (integer, fraction) 被注解的元素必须是一个数字，其值必须在可接受的范围内
@Past 被注解的元素必须是一个过去的日期
@Future 被注解的元素必须是一个将来的日期
@Pattern(regex=,flag=) 被注解的元素必须符合指定的正则表达式
@NotBlank(message =) 验证字符串非null，且长度必须大于0
@Email 被注解的元素必须是电子邮箱地址
@Length(min=,max=) 被注解的字符串的大小必须在指定的范围内
@NotEmpty 被注解的字符串的必须非空
@Range(min=,max=,message=) 被注解的元素必须在合适的范围内
 */
public class Book {

    @Length(min = 3,message = "{book.name.length}",groups = {ValitorGroup1.class,ValitorGroup2.class})
    private String name;    //书名长度必须大于3
    @NotNull(message = "{book.author.null}",groups = ValitorGroup2.class)
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
