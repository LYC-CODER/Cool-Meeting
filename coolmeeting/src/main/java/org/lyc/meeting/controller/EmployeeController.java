package org.lyc.meeting.controller;


import org.lyc.meeting.model.Employee;
import org.lyc.meeting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 员工
 */
@Controller
@RequestMapping("/admin")
public class EmployeeController {

    //一页放10条数据
    public static final Integer PAGE_SIZE = 10;

    @Autowired
    private EmployeeService employeeService;
    /**
     * 分页查询员工
     * 获取员工的数量
     *
     * employee 员工
     * page     页数
     * model
     * 搜索员工页面
     */
    @RequestMapping("/searchemployees")
    public String getAllEmployees(Employee employee, @RequestParam(defaultValue = "1") Integer page, Model model) {
        List<Employee> emps = employeeService.getAllEmps(employee, page, PAGE_SIZE);

        Long total = employeeService.getTotal(employee);

        model.addAttribute("emps", emps);
        model.addAttribute("total", total);
        model.addAttribute("page", page);
        model.addAttribute("pagenum",
                total % PAGE_SIZE == 0 ? total / PAGE_SIZE : total / PAGE_SIZE + 1);

        return "searchemployees";
    }

    /**
     * 关闭账号 修改状态为2
     *
     * id 员工编号
     * 重定向到审批通过的员工页面
     */
    @RequestMapping("/updateemp")
    public String updateemp(Integer id) {
        employeeService.updatestatus(id, 2);
        return "redirect:/admin/searchemployees?status=1";
    }
}
