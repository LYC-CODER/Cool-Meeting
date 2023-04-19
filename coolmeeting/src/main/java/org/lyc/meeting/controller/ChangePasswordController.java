package org.lyc.meeting.controller;

import org.lyc.meeting.model.Employee;
import org.lyc.meeting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChangePasswordController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * 跳转到changepassword页面
     * <p>
     * changepassword页面
     */
    @RequestMapping("/changepassword")
    public String changehtml() {
        return "changepassword";
    }

    /**
     * 修改密码具体操作
     * <p>
     * username    用户名
     * password    密码
     * newpassword 新密码
     * model       Model
     * 用户名密码对的上就修改成功，对不上就修改失败
     */
    @PostMapping("/dochange")
    public String dochange(String username, String password, String newpassword,Model model) {
        Employee employee = employeeService.doLogin(username, password);
        if (employee == null) {
            model.addAttribute("error", "用户名或原密码输入错误，修改失败");
            return "forward:changepassword";
        }else {
            employeeService.doChange(username,newpassword);
        }
        return "redirect:/";
    }
}
