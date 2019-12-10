# 动态SQL

动态SQL也是MyBatis的优势，动态SQL可以使开发者将一些简单的数据操作逻辑放到Mapper中。

## if

在条件满足时，动态的拼接SQL

```xml
<select id="getBookByAuthor" resultType="Book" parameterType="java.lang.String">
    select * from t_book
    <if test="author!=null">
        where author = #{author}
    </if>
</select>
```

## where

可以自动判断是否需要加上where，mybatis会在需要的地方自动加上where

```xml
<select id="getBookByAuthor2" resultType="top.woilanlan.bean.Book">
    <!--
    select * from t_book where 1=1
    -->
    select * from t_book
    <where>
        <if test="author!=null and author!=''">
            and author = #{author}
        </if>
        <if test="id!=null">
            and id > #{id}
        </if>
    </where>
</select>
```

## foreach

foreach用来遍历，遍历的对象可以是数组，也可以是集合。

接口

```java
public interface BookMapper {
    List<Book> getBooksByIds(@Param("ids") Integer[] ids);
    int addBook(@Param("books") List<Book> books);
}
```

xml文件

```xml
<select id="getBooksByIds" resultType="top.woilanlan.bean.Book">
    select * from t_book where id in
    <foreach collection="ids" item="id" separator="," open="(" close=")">
        #{id}
    </foreach>
</select>
<insert id="addBook">
    insert into t_book (author,b_name) values
    <foreach collection="books" item="book" separator=",">
        (#{book.author},#{book.name})
    </foreach>
</insert>
```

## trim

trim可以将SQL中最后的某个字符抹掉

```xml
<!-- 去掉最后面的逗号 -->
<update id="updateBookById">
    update t_book set
    <trim suffixOverrides=",">
        <if test="author!=null">
            author = #{author},
        </if>
        <if test="name!=null">
            b_name = #{name},
        </if>
    </trim>
    where id = #{id};
</update>
```

## set

也是用来解决更新问题的

## sql片段

sql片段一般用来定义sql中的列。

```xml
<sql id="sql1">
    tb.id as id,tb.b_name as name,tb.author as author
</sql>

<select id="getBooksByIds" resultType="top.woilanlan.bean.Book">
    select 
    <include refid="sql1"></include>
    from t_book tb where id in
    <foreach collection="ids" item="id" separator="," open="(" close=")">
        #{id}
    </foreach>
</select>
```