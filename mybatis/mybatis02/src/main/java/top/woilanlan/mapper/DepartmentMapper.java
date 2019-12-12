package top.woilanlan.mapper;

import java.util.List;
import top.woilanlan.bean.Department;
import top.woilanlan.bean.Employee;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    Department selectByPrimaryKey(Integer id);

    List<Department> selectAll();

    int updateByPrimaryKey(Department record);

    Department getDepartmentById(Integer id);

    Department getDepartmentById2(Integer id);

    List<Employee> getEmpsByDid(Integer did);
}