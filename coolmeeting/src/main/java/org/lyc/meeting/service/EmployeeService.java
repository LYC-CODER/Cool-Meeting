package org.lyc.meeting.service;


import org.lyc.meeting.mapper.EmployeeMapper;
import org.lyc.meeting.mapper.MeetingParticipantsMapper;
import org.lyc.meeting.model.Employee;
import org.lyc.meeting.model.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    MeetingParticipantsMapper meetingParticipantsMapper;
    /**
     * 登录
     * 先通过登录的用户名查询用户，判断用户是否存在，不存在则返回null
     * 或者判断用户输入的密码和查询出的密码是否一致，不一致则返回null
     * 其他情况返回员工信息
     * username 用户名
     * password 密码
     * 员工
     */
    public Employee doLogin(String username, String password) {
        Employee employee=employeeMapper.loadEmpByUsername(username);
        if (employee==null||!employee.getPassword().equals(password)){
            return null;
        }
        return employee;
    }
    /**
     * 做注册
     * 先通过注册的用户名查询用户，判断用户是否存在，存在则返回-1
     * 不存在则把用户设为普通用户并且把status设置为未审批
     * 然后注册
     *
     * employee 员工
     * Integer
     */
    public Integer doReg(Employee employee) {
        Employee emp = employeeMapper.loadEmpByUsername(employee.getUsername());
        if (emp!=null){
            return -1;
        }
        //普通用户
        employee.setRole(1);
        //status为未审批
        employee.setStatus(0);
        return employeeMapper.doReg(employee);
    }
    /**
     * 按状态获取所有员工
     *
     * status 状态
     * List<Employee>
     */
    public List<Employee> getAllEmpsBystatus(Integer status) {
        return employeeMapper.getAllEmpsBystatus(status);
    }
    /**
     * 更新状态
     *
     * employeeid 员工ID
     * status     状态
     * Integer
     */
    public Integer updatestatus(Integer employeeid, Integer status) {
        return employeeMapper.approveaccount(employeeid,status);
    }
    /**
     * 分页查询获得所有Emps
     *
     * employee 员工
     * page     页数
     * pageSize 查几条数据
     *
     */
    public  List<Employee> getAllEmps(Employee employee, Integer page, Integer pageSize) {
        //这个page是从第几行数据开始查
        page = (page - 1) * pageSize;
        return employeeMapper.getAllEmps(employee,page,pageSize);
    }

    /**
     * 获取员工数量
     *
     * employee 员工
     * 员工数量
     */
    public Long getTotal(Employee employee) {
        return employeeMapper.getTotal(employee);
    }
    /**
     * 通过部门编号获取员工
     *
     * depId 部门编号
     * List<Employee>
     */
    public List<Employee> getEmpsByDepId(Integer depId) {
        return employeeMapper.getEmpsByDepId(depId);
    }
    /**
     * 修改密码
     *
     * username    用户名
     * newpassword 新密码
     */
    public void doChange(String username, String newpassword) {
        employeeMapper.doChange(username,newpassword);
    }
    /*
     * 通过meetingid获取员工信息
     *
     * meetingid Integer
     * List<Employee>
     */
    public List<Employee> getEmpsByid(Integer meetingid) {
        List<Integer> list = meetingParticipantsMapper.getAllBymeetingid(meetingid);
        return employeeMapper.getAllempsByid(list);

    }
}
