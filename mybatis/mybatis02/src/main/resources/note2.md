# Mapper的XML文件配置

## 引入参数#和$

由于MyBatis底层还是Jdbc，而Jdbc在操作数据库传递参数时，有两种方式，一种是使用Statement，还有一种是使用PreparedStatement，
使用statement时，存在SQL注入问题，PreparedStatement则通过预编译解决了SQL注入问题。

在MyBatis种，引入参数有两种方式，一种是使用#，还有一种是使$，
其中，使用#对应了Jdbc种的PreparedStatement，而使用则对应了Jdbc种的Statement，因此在MyBatis种，推荐使用#

查看方式：

1、引入MyBatis日志依赖

```xml
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.28</version>
</dependency>
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-log4j12</artifactId>
    <version>1.7.28</version>
</dependency>
```

2、可以使用$替换#，如果使用$，需要在Mapper种指定参数名字。

## 多个参数

如果Mapper接口中有多个参数，无论参数名是什么，在Mapperxm文件中，参数都是arg0、arg1或者paraml、param2

如果非要使用自己的参数名，可以通过@Param注解自定义

## 包装对象

1、定义包装类 top.woilanlan.bean.UserWrapper

2、xml文件,SQL如下定义

```xml
<insert id="addUser2" parameterType="top.woilanlan.bean.UserWrapper">
    insert into t_user (name,age,address,favorites) values (#{user.name},#{user.age},#{user.address},#{user.favorites,typeHandler=top.woilanlan.handler.ListStringHandler});
</insert>
```

## Map

也可以使用HashMap做参数，使用Map做参数，非常灵活，但是不推荐。