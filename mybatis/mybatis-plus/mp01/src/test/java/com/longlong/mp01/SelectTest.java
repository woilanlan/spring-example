package com.longlong.mp01;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.longlong.mp01.bean.User;
import com.longlong.mp01.dao.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectTest {

    @Autowired
    private UserMapper userMapper;

    /*
    查询所有
     */
    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    /*
    新增
    日志打印：
    Preparing: INSERT INTO user ( id, create_time, name, email, age ) VALUES ( ?, ?, ?, ?, ? )
    Parameters: 1191293641610248193(Long), 2019-11-04T17:58:31.389(LocalDateTime), 花木兰(String), hml@gmail.com(String), 20(Integer)

    user：对应实体类的驼峰写法
    id：采用雪花算法的自增id,主键默认查找 id
    create_time：对应实体类属性的驼峰写法
     */
    @Test
    public void insert(){
        User user = new User();
        user.setName("项羽");
        user.setAge(20);
        user.setEmail("xy@gmail.com");
        user.setCreateTime(LocalDateTime.now());
        int rows = userMapper.insert(user);
        System.out.println("影响记录数："+ rows);
    }

    @Test
    public void selectById(){
        User user = userMapper.selectById(1191346564329897985L);
        System.out.println(user);
    }

    @Test
    public void selectIds(){
        List<Long> list = Arrays.asList(1191346564329897985L, 10L, 9L);
        List<User> userList = userMapper.selectBatchIds(list);
        userList.forEach(user -> {
            System.out.println(user);
        });
    }

    @Test
    public void selectByMap(){
        //key为数据库的字段名
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("name","项羽");
        columnMap.put("age",20);
        userMapper.selectByMap(columnMap);
    }

    /*
    1、名字中包含雨并且年龄小于40
    name like '%雨%' and age < 40
     */
    @Test
    public void selectByWrapper(){
        //通过工具类创建
        //QueryWrapper<User> query = Wrappers.<User>query();

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","羽").lt("age",40);
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /*
    名字中包含雨并且年龄大于等于20且小于等于40并且email不为空
    name like '%雨%' and age between 20 and 40 and email is not null
     */
    @Test
    public void selectByWrapper2(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","羽").between("age",20,40).isNotNull("email");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /*
    名字为王姓或者年龄大于等于18，按照年龄降序排列，年龄相同按照id升序排列
    name like '王%' or age >= 8 order by age desc , id asc
     */
    @Test
    public void selectByWrapper3(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("name","王").or().ge("age",18).orderByDesc("age").orderByAsc("id");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /*
    创建日期为2019年2月14日并且直属上级的名字为王姓
    date_format（create_time，%Y-%m-%d"）and manager_id in (select id from user where name like '王%')
     */
    @Test
    public void selectByWrapper4(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.apply("date_format(create_time,'%Y-%m-%d') = {0}","2019-11-04")
                .inSql("manager_id","select id from user where name like '王%' ");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /*
    名字为王姓并且（年龄小于40或邮箱不为空）
    name like '王%' and（age<40 or email is not null）
     */
    @Test
    public void selectByWrapper5(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("name","王").and(wq->wq.lt("age",40).or().isNotNull("email"));
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /*
    名字为王姓或者（年龄小于40并且年龄大于20并且邮箱不为空）
    name like '王%' or（age<40 and age>20 and email is not null）
     */
    @Test
    public void selectByWrapper6(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("name","王")
                .or(wq->wq.lt("age",40).gt("age","20").isNotNull("email"));
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /*
    （年龄小于40或邮箱不为空）并且名字为王姓
    （age<40 or email is not null） and name like '王%'
     */
    @Test
    public void selectByWrapper7(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.nested(wq->wq.lt("age",40).or().isNotNull("email"))
                .likeRight("name","王");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /*
    年龄为30、31、34、35
    age in (30,31,34,35)
     */
    @Test
    public void selectByWrapper8(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("age",Arrays.asList(30,31,34,35));
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /*
    只返回满足条件的其中一条语句即可
    limit 1
     */
    @Test
    public void selectByWrapper9(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("age",Arrays.asList(18,21,34,35)).last("limit 1");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }


    /*
    不列出全部字段
     */
    @Test
    public void selectByWrapperSupper(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id","name").like("name","羽").lt("age",40);
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /*
    不列出全部字段2
    */
    @Test
    public void selectByWrapperSupper2(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","羽").lt("age",40)
                .select(User.class, info->!info.getColumn().equals("create_time")&&
                        !info.getColumn().equals("manager_id"));
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    private void condition(String name,String email){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        if(StringUtils.isNotEmpty(name)){
//            queryWrapper.like("name",name);
//        }
//        if(StringUtils.isNotEmpty(email)){
//            queryWrapper.like("email",email);
//        }
        queryWrapper.like(StringUtils.isNotEmpty(name),"name",name)
                .like(StringUtils.isNotEmpty(email),"email",email);
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /*
    condition 的作用
     */
    @Test
    public void testCondition(){
        String name = "关羽";
        String email = "gy";
        condition(name,email);
    }

    /*
    实体作为条件构造器构造方法的参数
    实体属性添加注解：
    @TableField(condition = SqlCondition.LIKE)
     */
    @Test
    public void selectByWrapperEntity(){
        User searchUser = new User();
        searchUser.setName("项羽");
        searchUser.setAge(21);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(searchUser);
        //queryWrapper.like("name","羽").lt("age",40);
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /*
    allEq
     */
    @Test
    public void selectByWrapperAllEq(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        Map<String,Object> params = new HashMap<>();
        params.put("name","关羽");
        params.put("age",null);
//        queryWrapper.allEq(params);   // age is null
//        queryWrapper.allEq(params,false);   // 忽略 age 条件

        //过滤，忽略 name 条件
        queryWrapper.allEq((k,v)->!k.equals("name"),params);
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /*
    应用场景：
    1、当你表字段特别多的时候，只需要其中几列，没有必要返回泛型为实体类的list
    2、返回的不是一条条记录，是一个统计查询，返回统计结果
     */
    @Test
    public void selectByWrapperMaps(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name","email").like("name","羽").lt("age",40);
        List<Map<String, Object>> userList = userMapper.selectMaps(queryWrapper);
        userList.forEach(System.out::println);
    }

    /*
    按照直属上级分组，查询每组的平均年龄、最大年龄、最小年龄，并且只取年龄总和小于500的组。
    select manager_id,avg(age) avg_age,min(age) min_age,max(age) max_age
    from user
    group by manager_id
    having sum(age) < 500;
     */
    @Test
    public void selectByWrapperMaps2(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("manager_id","avg(age) avg_age","min(age) min_age","max(age) max_age")
                .groupBy("manager_id").having("sum(age) < {0}",500);
        List<Map<String, Object>> userList = userMapper.selectMaps(queryWrapper);
        userList.forEach(System.out::println);
    }

    /*
    selectObjs 除了第一列，其他的都被舍弃了。
     */
    @Test
    public void selectByWrapperObjs(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name","email").like("name","羽").lt("age",40);
        List<Object> userList = userMapper.selectObjs(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void selectByWrapperCount(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","羽").lt("age",40);
        Integer count = userMapper.selectCount(queryWrapper);
        System.out.println(count);
    }

    /*
    返回多个结果将会报错
     */
    @Test
    public void selectByWrapperOne(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","关羽").lt("age",40);
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }

    /*'
    防误写
     */
    @Test
    public void selectLambda(){
//        LambdaQueryWrapper<User> lambda = new QueryWrapper<User>().lambda();
//        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        LambdaQueryWrapper<User> lambdaQuery = Wrappers.<User>lambdaQuery();
        lambdaQuery.like(User::getName,"羽").lt(User::getAge,40);
        List<User> userList = userMapper.selectList(lambdaQuery);
        userList.forEach(System.out::println);
    }

    @Test
    public void selectLambda3(){
        List<User> userList = new LambdaQueryChainWrapper<User>(userMapper)
                .like(User::getName, "羽").ge(User::getAge, 20).list();
        userList.forEach(System.out::println);
    }

    /*
    自定义方法
     */
    @Test
    public void selectMy(){
        LambdaQueryWrapper<User> lambdaQuery = Wrappers.<User>lambdaQuery();
        lambdaQuery.like(User::getName,"羽").lt(User::getAge,40);
        List<User> userList = userMapper.selectAll(lambdaQuery);
        userList.forEach(System.out::println);
    }
}
