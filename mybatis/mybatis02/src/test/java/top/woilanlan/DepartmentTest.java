package top.woilanlan;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import top.woilanlan.bean.Department;
import top.woilanlan.bean.Employee;
import top.woilanlan.mapper.DepartmentMapper;
import top.woilanlan.mapper.EmployeeMapper;

import java.io.IOException;

public class DepartmentTest {
    private SqlSession sqlSession;
    private DepartmentMapper departmentMapper;


    @Before
    public void before() throws IOException {
        sqlSession = DBUtils.getInstance().openSession();
        departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
    }

    @After
    public void after(){
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test(){
        Department department = departmentMapper.getDepartmentById(5);
        System.out.println(department);
    }

    @Test
    public void test2(){
        Department department = departmentMapper.getDepartmentById2(5);
//        System.out.println(department.getName());
        System.out.println(department);
    }

    /*
    一级缓存，发现只执行了一次
     */
    @Test
    public void test3(){
        Department department = departmentMapper.getDepartmentById2(5);
        System.out.println(department.getName());
        Department department2 = departmentMapper.getDepartmentById2(5);
        System.out.println(department2.getName());
    }

    /*
    执行两次sql
     */
    @Test
    public void test4(){
        Department department = departmentMapper.getDepartmentById2(5);
        System.out.println(department.getName());
        sqlSession.commit();
        sqlSession.close();
        sqlSession = DBUtils.getInstance().openSession();
        departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        Department department2 = departmentMapper.getDepartmentById2(5);
        System.out.println(department2.getName());
    }
}
