package top.woilanlan.mapper;

import java.util.List;
import top.woilanlan.bean.Employee;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer employeeid);

    int insert(Employee record);

    Employee selectByPrimaryKey(Integer employeeid);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee record);
}