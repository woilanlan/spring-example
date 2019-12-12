package top.woilanlan;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import top.woilanlan.bean.Employee;
import top.woilanlan.mapper.EmployeeMapper;

import java.io.IOException;

public class EmployeeTest {
    private SqlSession sqlSession;
    private EmployeeMapper employeeMapper;

    @Before
    public void before() throws IOException {
        sqlSession = DBUtils.getInstance().openSession();
        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
    }

    @After
    public void after(){
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test(){
        Employee employee = employeeMapper.getEmployeeById(1);
        System.out.println(employee);
    }

    @Test
    public void test2(){
        Employee employee = employeeMapper.getEmployeeById2(1);
        System.out.println(employee.getName());
        //System.out.println(employee);
    }
}
