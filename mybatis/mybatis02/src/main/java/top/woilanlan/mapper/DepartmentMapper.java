package top.woilanlan.mapper;

import java.util.List;
import top.woilanlan.bean.Department;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    Department selectByPrimaryKey(Integer id);

    List<Department> selectAll();

    int updateByPrimaryKey(Department record);

    Department getDepartmentById(Integer id);
}