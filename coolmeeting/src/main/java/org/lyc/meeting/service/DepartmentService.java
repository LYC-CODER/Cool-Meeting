package org.lyc.meeting.service;

import org.lyc.meeting.mapper.DepartmentMapper;
import org.lyc.meeting.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    /**
     * 通过部门编号获取部门
     *
     * id 部门编号
     * 部门
     */
    public Department getDepById(Integer id){
        return departmentMapper.getDepById(id);
    }
    /**
     * 获取所有部门
     *
     * List<Department>
     */
    public List<Department> getAllDeps() {
        return departmentMapper.getAllDeps();
    }
    /**
     * 增加部门
     * 增加部门前判断部门是否存在，存在则不添加部门，不存在则添加
     *
     * departmentname 部门名称
     * Integer
     */
    public Integer adddepartment(String departmentname) {
        Department dep = departmentMapper.getDepByName(departmentname);
        if(dep!=null){
            return -1;
        }
        return departmentMapper.adddepartment(departmentname);
    }
    /**
     * 删除部门
     *
     * departmentid 部门编号
     * Integer
     */
    public Integer deletedep(Integer departmentid) {
        return departmentMapper.deletedep(departmentid);
    }
    /**
     * 更新部门
     *
     * id   部门编号
     * name 部门名称
     * Integer
     */
    public Integer updatedep(Integer id, String name) {
        return departmentMapper.updatedep(id,name);
    }
}
