# Mapper的XML文件配置

## 输入参数

### #和$

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

### 多个参数

如果Mapper接口中有多个参数，无论参数名是什么，在Mapperxm文件中，参数都是arg0、arg1或者paraml、param2

如果非要使用自己的参数名，可以通过@Param注解自定义

### 包装对象

1、定义包装类 top.woilanlan.bean.UserWrapper

2、xml文件,SQL如下定义

```xml
<insert id="addUser2" parameterType="top.woilanlan.bean.UserWrapper">
    insert into t_user (name,age,address,favorites) values (#{user.name},#{user.age},#{user.address},#{user.favorites,typeHandler=top.woilanlan.handler.ListStringHandler});
</insert>
```

### Map

也可以使用HashMap做参数，使用Map做参数，非常灵活，但是不推荐。

## resultType

对于简单数据类型，例如查询总记录数、查询某一个用户名这一类返回值是一个基本数据类型的，直接写Java中的基本数据类型即可。、
如果返回的是一个对象或者集合，并且对象中的属性和查询的字段名是——对应的，那么resultType也可以直接写一个对象。

也可以输出一个HashMap,Map比较灵活，但是实际开发中使用较少。

```xml
<select id="getUserById2" resultType="java.util.HashMap">
    select * from t_user where id = #{id};
</select>
```

## resultMap

无论是resultMap还是resultType，对象都是通过反射创建出来的。

resultMap主要用来解决属性名和字段名不一致以及一对多、一对一查询等问题
字段名不一致时，首先可以通过取别名解决，

```xml
<select id="getAllBook" resultType="top.woilanlan.bean.Book">
    select id,author,tb.b_name as name from t_book tb;
</select>
```

这种方式，可以解决问题，但是有缺陷，最大缺陷是不能复用。(可以sql片段解决，但是不完美)

所以，最佳解决方案就是使用resultMap，用法如下：

```xml
<resultMap id="baseResultMap" type="top.woilanlan.bean.Book">
    <id property="id" column="id"/>
    <result property="author" column="author"/>
    <result property="name" column="b_name"/>
</resultMap>
<select id="getAllBook" resultMap="baseResultMap">
    select * from t_book tb;
</select>
```

实际上，resultMap也是调用了Book的无参构造方法。

也可以直接调用指定的的构造方法

```xml
<!-- 定义映射关系 -->
<resultMap id="baseResultMap" type="top.woilanlan.bean.Book">
    <constructor>
        <idArg column="id" name="id"/>
        <arg column="author" name="author"/>
    </constructor>

    <!--
    <constructor>
        <idArg column="id" name="arg0" javaType="java.lang.Integer"/>
        <arg column="author" name="arg1" javaType="java.lang.String"/>
    </constructor>
    -->
</resultMap>
```