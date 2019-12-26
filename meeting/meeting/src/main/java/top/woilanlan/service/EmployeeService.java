package top.woilanlan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.woilanlan.bean.Employee;
import top.woilanlan.mapper.EmployeeMapper;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public Employee doLogin(String username, String password) {
        return employeeMapper.doLogin(username,password);
    }
}
