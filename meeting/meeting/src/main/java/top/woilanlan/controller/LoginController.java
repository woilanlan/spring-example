package top.woilanlan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import top.woilanlan.bean.Employee;
import top.woilanlan.service.EmployeeService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(String username, String password, Model model, HttpServletRequest req){
        Employee employee = employeeService.doLogin(username,password);
        if (employee != null) {
            if("1".equals(employee.getStatus())){
                req.getSession().setAttribute("LoginUser",employee);
                return "redirect:/notifications";
            }
            else if("0".equals(employee.getStatus())){
                model.addAttribute("msg","账户未审批,请联系管理员");
            }else if("2".equals(employee.getStatus())){
                model.addAttribute("msg","审批未通过,请联系管理员");
            }else if("3".equals(employee.getStatus())){
                model.addAttribute("msg","账户被锁定，请联系管理员");
            }

        }else {
            model.addAttribute("msg","用户名或密码有误，登录失败");
        }
        return "login";
    }
}
