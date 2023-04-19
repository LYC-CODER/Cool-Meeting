package org.lyc.meeting.mapper;

import org.apache.ibatis.annotations.Param;
import org.lyc.meeting.model.Employee;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface EmployeeMapper {
    /**
     * 通过用户名查询员工
     *
     * username 用户名
     * 员工
     */
    Employee loadEmpByUsername(String username);
    /**
     * 做注册
     *
     * employee 员工
     * 注册返回值
     */
    Integer doReg(Employee employee);
    /**
     * 按状态获取所有员工
     *
     * status 状态
     * List<Employee>
     */
    List<Employee> getAllEmpsBystatus(Integer status);
    /**
     * 更新状态
     *
     * employeeid 员工ID
     * status     状态
     * Integer
     */
    Integer approveaccount(@Param("employeeid") Integer employeeid,@Param("status") Integer status);
    /**
     * 根据status分页获得员工
     *
     * employee 员工
     * page     从第几行数据开始查
     * pageSize 查几条数据
     * List<Employee>
     */
    List<Employee> getAllEmps(@Param("emp") Employee employee,@Param("page") Integer page,@Param("pagesize") Integer pageSize);
    /**
     * 根据status获得员工的数量
     *
     * employee 员工
     * 数量
     */
    Long getTotal(Employee employee);
    /**
     * 通过部门编号获取员工
     *
     * depId 部门编号
     * List<Employee>
     */
    List<Employee> getEmpsByDepId(Integer depId);

    /**
     * 修改密码
     *
     * username    用户名
     * newpassword 新密码
     */
    void doChange(@Param("username") String username,@Param("newpassword") String newpassword);
    /**
     * 通过employeeid集合获取员工的信息
     *
     * list List<Integer>
     * List<Employee>
     */
    List<Employee> getAllempsByid(List<Integer> list);
}
