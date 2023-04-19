package org.lyc.meeting.mapper;

import org.apache.ibatis.annotations.Param;
import org.lyc.meeting.model.Department;

import java.util.List;

public interface DepartmentMapper {
    /*
     *根据部门编号获取部门信息
     * id 部门编号
     * 部门信息
     */
    Department getDepById(Integer id);

    /*
     *获取所以部门信息
     *list集合里包括所以的部门信息
     */
    List<Department> getAllDeps();

    /*
     *增加部门
     *departmentname 部门名称
     *部门增加成功返回增加成功的数量
     */
    Integer adddepartment(String departmentname);
    /*
     *通过部门名称获取部门信息
     *
     *departmentname 部门名称
     *部门信息
     */
    Department getDepByName(String departmentname);
    /*
     *通过部门编号删除部门
     *
     *departmentid 部门编号
     *部门删除成功返回删除成功的数量
     */
    Integer deletedep(Integer departmentid);
    /*
     *更新部门名称
     *
     *id   部门编号
     *name 部门名称
     *部门更新成功返回更新成功的数量
     */
    Integer updatedep(@Param("id") Integer id, @Param("name") String name);
}
