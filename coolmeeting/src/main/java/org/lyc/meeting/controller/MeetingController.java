package org.lyc.meeting.controller;

import org.lyc.meeting.model.Department;
import org.lyc.meeting.model.Employee;
import org.lyc.meeting.model.Meeting;
import org.lyc.meeting.model.MeetingDTO;
import org.lyc.meeting.service.DepartmentService;
import org.lyc.meeting.service.EmployeeService;
import org.lyc.meeting.service.MeetingRoomService;
import org.lyc.meeting.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MeetingController {
    @Autowired
    MeetingRoomService meetingRoomService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    MeetingService meetingService;
    /**
     * 会议预订页面
     *
     * bookmeeting
     */
    @RequestMapping("/bookmeeting")
    public String bookmeeting(Model model){
        //让bookmeeting页面展示出数据库中的会议室名称
        model.addAttribute("mrs",meetingRoomService.getAllMr());
        return "bookmeeting";
    }
    /**
     * 获取所有的部门
     *
     * List<Department>
     */
    @RequestMapping("/alldeps")
    @ResponseBody
    public List<Department> getAllDeps(){
        return departmentService.getAllDeps();
    }
    /**
     * 通过部门编号获取员工
     *
     * depId 部门编号
     * List<Employee>
     */
    @RequestMapping("/getempbydepid")
    @ResponseBody
    public List<Employee> getEmpsByDepId(Integer depId){
        return employeeService.getEmpsByDepId(depId);
    }
    /**
     * 增加会议操作
     *
     * meeting Meeting
     * mps     参会人数
     * session HttpSession
     * 预订成功返回searchmeetings视图   失败返回bookmeeting页面
     */
    @RequestMapping("/doAddMeeting")
    public String doAddMeeting(Meeting meeting , Integer[] mps, HttpSession session){
        Employee currentuser = (Employee) session.getAttribute("currentuser");
        meeting.setReservationistid(currentuser.getEmployeeid());
        //给meeting的status设置状态为0 （0代表有的会议，1代表取消的会议）
        Integer result = meetingService.addMeeting(meeting,mps);
        if (result==1){
            return "redirect:/searchmeetings";
        }else {
            return "forward:/bookmeeting";
        }
    }
    //一页放10条数据
    public static final Integer PAGE_SIZE = 10;
    /**
     * 返回搜索会议页面
     *
     * searchmeetings
     */
    @RequestMapping("/searchmeetings")
    public String getAllmMeeting(MeetingDTO meetingDTO , @RequestParam(defaultValue = "1")Integer page,Model model){
        List<MeetingDTO> listMeetingDTOs = meetingService.listMeetingDTOs(meetingDTO,page,PAGE_SIZE);
        Long total = meetingService.getTotal(meetingDTO);
        model.addAttribute("meetings",listMeetingDTOs);
        model.addAttribute("total",total);
        model.addAttribute("page",page);
        model.addAttribute("pagenum",total%PAGE_SIZE==0?total/PAGE_SIZE:total/PAGE_SIZE+1);

        return "searchmeetings";
    }
    /**
     * 返回meetingdetails页面并且根据meetingid添加会议到model中
     *
     * meetingid Integer
     * model     Model
     * meetingdetails
     */
    @RequestMapping("/meetingdetails")
    public String meetingdetails(Integer meetingid,Model model){
        Meeting meeting = meetingService.getmeetingByid(meetingid);
        model.addAttribute("meeting",meeting);
        List<Employee> listEmployee = employeeService.getEmpsByid(meetingid);
        model.addAttribute("ems",listEmployee);
        return "meetingdetails";
    }
}
