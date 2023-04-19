package org.lyc.meeting.controller;


import org.lyc.meeting.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 部门
 */
@Controller
@RequestMapping("/admin")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;
    /**
     * 获取所有部门
     *
     * model
     * 返回视图到departments.ftl
     */
    @RequestMapping("/departments")
    public String departments(Model model){
        model.addAttribute("deps",departmentService.getAllDeps());
        return "departments";
    }
    /**
     * 增加部门
     *
     * departmentname 部门名称
     * 重定向到获取所有部门的页面
     */
    @RequestMapping("/adddepartment")
    public String adddepartment(String departmentname){
        departmentService.adddepartment(departmentname);
        return "redirect:/admin/departments";
    }
    /**
     * 删除部门
     *
     * departmentid 部门编号
     * 重定向到获取所有部门的页面
     */
    @RequestMapping("/deletedep")
    public String deletedepartment(Integer departmentid){
        departmentService.deletedep(departmentid);
        return "redirect:/admin/departments";
    }
    /**
     * 更新部门
     *
     * id   部门编号
     * name 部门名称
     * success或者error给前端ajax
     */
    @RequestMapping("/updatedep")
    @ResponseBody
    public String updatedep(Integer id,String name){
        Integer result = departmentService.updatedep(id,name);
        if (result==1){
            return "success";
        }
        return "error";
    }
}
