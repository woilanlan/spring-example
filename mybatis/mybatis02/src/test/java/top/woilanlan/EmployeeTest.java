package top.woilanlan;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
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
}
