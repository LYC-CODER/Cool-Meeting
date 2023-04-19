package org.lyc.meeting.controller;


import org.lyc.meeting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 批准帐户
 * status=0为待批准
 * status=1为批准通过
 * status=2为批准未通过
 */
@Controller
@RequestMapping("/admin")
public class ApproveaccountController {
    //待批准状态码为0
    public static final Integer PENDING_APPROVE = 0;
    /**
     * 获取所有待批准的用户
     * <p>
     * model
     * 返回视图到approveaccount.ftl
     */
    @Autowired
    EmployeeService employeeSvervice;

    @RequestMapping("/approveaccount")
    public String approveaccount(Model model) {
        model.addAttribute("emps", employeeSvervice.getAllEmpsBystatus(0));
        return "approveaccount";
    }
    /**
     更新用户状态(status)
     employeeid 员工ID
     status     更新的状态
     重定向到 取所有待批准的用户 页面
     */
    @RequestMapping("/updatestatus")
    public String updatestatus(Integer employeeid, Integer status) {
        Integer result = employeeSvervice.updatestatus(employeeid, status);
        return "redirect:/admin/approveaccount";
    }
}
