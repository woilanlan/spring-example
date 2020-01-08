package top.woilanlan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.woilanlan.bean.Department;
import top.woilanlan.mapper.DepartmentMapper;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    public List<Department> getAlldepartment() {
        return departmentMapper.selectAll();
    }

    public String addDep(String depName) {
        Department department = departmentMapper.getDepByName(depName);
        if(department != null){
            return "部门已经存在，添加失败!";
        }
        Department record = new Department();
        record.setDepartmentname(depName);
        departmentMapper.insert(record);
        return null;
    }

    public void deleteById(Integer id) {
        departmentMapper.deleteByPrimaryKey(id);
    }
}
