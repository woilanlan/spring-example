# 延迟查询

延迟查询是一对一和一对多查询的延续。

在默认的一对一和一对多中，一条SQL就能够查询到所有数据，但是，有的数据有时候一时半会用不上，
例如查询员工，捎带获取员工的部门数据，但是部门数据使用的频率很低，这种时候可以使用延迟查询，
首先获取到所有的员工数据，然后在需要的时候再去获取部门数据。

首先定义两个方法，分别根据id查询员工以及根据部门id查询部门：

```java
public interface EmployeeMapper {
    Employee getEmployeeById2(Integer eid);
    Department getDeptByEid(Integer did);
}
```

然后XL文件中定义映射关系以及延迟查询：

```xml
<resultMap id="BaseResultMap3" type="top.woilanlan.bean.Employee" extends="BaseResultMap">
    <association property="department"
                 select="top.woilanlan.mapper.EmployeeMapper.getDeptByEid"
                 column="departmentId"
                 fetchType="lazy">
    </association>
</resultMap>

<resultMap id="DepResultMap" type="top.woilanlan.bean.Department">
    <id column="id" jdbcType="INTEGER" property="id" />
    <result column="name" jdbcType="VARCHAR" property="name" />
    <result column="parentId" jdbcType="INTEGER" property="parentid" />
    <result column="depPath" jdbcType="VARCHAR" property="deppath" />
    <result column="enabled" jdbcType="BIT" property="enabled" />
    <result column="isParent" jdbcType="BIT" property="isparent" />
</resultMap>

<select id="getEmployeeById2" resultMap="BaseResultMap3">
    select * from employee where id = #{eid}
</select>

<select id="getDeptByEid" resultMap="DepResultMap">
    select * from department where id = #{did};
</select>
```

这个是一对一中的延迟查询，对于一对多，写法类似。

注意：如果一个对象的某个属性较少用到，那么可以使用延迟查询，如果使用频率很高，则首选多表联合查询。