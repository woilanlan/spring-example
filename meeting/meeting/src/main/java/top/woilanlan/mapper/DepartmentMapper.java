package top.woilanlan.mapper;

import java.util.List;
import top.woilanlan.bean.Department;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer departmentid);

    int insert(Department record);

    Department selectByPrimaryKey(Integer departmentid);

    List<Department> selectAll();

    int updateByPrimaryKey(Department record);
}