package top.woilanlan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.woilanlan.bean.Department;
import top.woilanlan.bean.RespBean;
import top.woilanlan.service.DepartmentService;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/departments")
    public String departments(Model model){
        model.addAttribute("departments",departmentService.getAlldepartment());
        return "departments";
    }

    @PostMapping("/dep")
    public String addDep(String depName,Model model){
        String msg = departmentService.addDep(depName);
        if (msg != null) {
            model.addAttribute("msg",msg);
        }
        //重定向数据会丢失
        //return "redirect:/departments";
        model.addAttribute("departments",departmentService.getAlldepartment());
        return "departments";
    }

    @GetMapping("/dep")
    public String deleteById(Integer id,Model model){
        departmentService.deleteById(id);
        model.addAttribute("departments",departmentService.getAlldepartment());
        return "departments";
    }

    @PostMapping("/updateDep")
    @ResponseBody
    public RespBean updateDep(Department department){
        int result = departmentService.updateDep(department);
        if(result == 1){
            return RespBean.ok("修改成功！");
        }
        return RespBean.error("修改失败！");
    }
}
