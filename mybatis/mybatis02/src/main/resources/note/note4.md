# 主键回填

一般情况下，主键有两种生成方式：

1. 主键自增长
2. 自定义主键（一般可以使用UUID）

如果是第二种，主键一般是在Java代码中生成，然后传入数据库执行，如果是第一个主键自增长，此时，Java可能需要知道数据添加成功后的主键

在MyBatis中，可以通过主键回填来解决这个问题（推荐）

```xml
<insert id="insertBook" useGeneratedKeys="true" keyProperty="id">
    insert into t_book (b_name,author) values (#{name},#{author});
</insert>
```

插入成功后，id会被赋值到刚刚传入的对象属性上去。

可以利用MySQL自带的last_insert_id()函数查询刚刚插入的id

```xml
<insert id="insertBook">
    <selectKey keyProperty="id" resultType="java.lang.Integer">
        select last_insert_id();
    </selectKey>
    insert into t_book (b_name,author) values (#{name},#{author});
</insert>
```