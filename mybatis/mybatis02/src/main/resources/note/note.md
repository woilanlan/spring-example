# mybatis-conf配置

- properties（属性）
- settings（全局配置参数）
- typeAliases（类型别名）
- typeHandlers（类型处理器）
- objectFactory（对象工厂）
- plugins（插件）
- environments（环境集合属性对象）
- environment（环境子属性对象）
- transactionManager（事务管理）
- dataSource（数据源）
- mappers（映射器）

## 1、properties（属性）

配置一些常见变量，类似于spring中placeholder的作用。一般可以用来引入数据库配置

## 2、typeAliases（类型别名）

mybatis提供的别名，例如
resultType="java.lang.Long" 可以简写为 resultType="long"

自定义别名(单个或批量)

## 3、typeHandlers（类型处理器）

就是实现ava类型和数据库类型之间转换的，除了系统提供的类型转换器之外，开发者也可以自定义类型转换

例如List<--->VARCHAR之间的类型转换：```top.woilanlan.handler.ListStringHandler```

插入操作，可以在Mapper中直接配置：```#{favorites,typeHandler=top.woilanlan.handler.ListStringHandler}```

查询操作，配置如下

```xml
<typeHandlers>
    <typeHandler handler="top.woilanlan.handler.ListStringHandler"/>
</typeHandlers>
```

拓展：<https://blog.csdn.net/u012702547/article/details/54572679>

## 4、mappers（映射器）

Mapper配置的几种方法：

4.1 使用相对于类路径的资源

```xml
<mapper resource="" />
<mapper resource="mapping/User.xml" />
```

4.2 注册指定包下的所有mapper接口

```xml
<package name=""/>
<package name="org.sang.mybatis.mapper"/>
```

注意：此种方法要求mapper接口名称和mapper映射文件名称相同，且放在同一个目录中。

4.3 使用mapper接口类路径

```xml
<mapper class=" " />
<mapper class="org.sang.mapper.UserMapper"/>
```

注意：此种方法要求mapper接口名称和mapper映射文件名称相同，且放在同一个目录中。

4.4 使用完全限定路径

```xml
<mapper url="" />
<mapper url="file:///D:\mybatis_01\config\sqlmap\User.xml" />
```
