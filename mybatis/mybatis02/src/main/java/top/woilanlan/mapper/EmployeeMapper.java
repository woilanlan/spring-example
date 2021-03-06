package top.woilanlan.mapper;

import java.util.List;

import top.woilanlan.bean.Department;
import top.woilanlan.bean.Employee;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Integer id);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee record);

    Employee getEmployeeById(Integer eid);

    Employee getEmployeeById2(Integer eid);

    Department getDeptByEid(Integer did);
}