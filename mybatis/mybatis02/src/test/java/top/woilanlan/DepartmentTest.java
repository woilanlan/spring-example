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
}
