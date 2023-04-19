package org.lyc.meeting.controller;

import org.lyc.meeting.model.Employee;
import org.lyc.meeting.model.Meeting;
import org.lyc.meeting.model.MeetingDTO;
import org.lyc.meeting.service.EmployeeService;
import org.lyc.meeting.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ChangeBookingController {
    @Autowired
    private MeetingService meetingService;

    @Autowired
    EmployeeService employeeService;

    /*
     * 返回我的预订页面
     *
     *  httpSession HttpSession
     *  model       Model
     *  mybookings
     */
    @RequestMapping("/mybookings")
    public String mybookings(HttpSession httpSession, Model model) {
        Employee currentuser = (Employee) httpSession.getAttribute("currentuser");
        Integer employeeid = currentuser.getEmployeeid();
        List<MeetingDTO> list = meetingService.getmeetingofmybookCanCancle(employeeid);
        model.addAttribute("mlist", list);
        return "mybookings";
    }

    /*
     * 预订会议里的详情页面
     *
     *  meetingid Integer
     *  model     Model
     *  mymeetingdetails页面
     */
    @RequestMapping("/mymeetingdetails")
    public String meetingdetails(Integer meetingid, Model model) {
        Meeting meeting = meetingService.getmeetingByid(meetingid);
        model.addAttribute("meeting", meeting);
        List<Employee> listEmployee = employeeService.getEmpsByid(meetingid);
        model.addAttribute("ems", listEmployee);
        return "mymeetingdetails";
    }
    /*
     * 撤销会议页面
     *
     * meetingid   Integer
     * meetingname String
     * model       Model
     * cancelmeeting页面
     */
    @GetMapping("/cancelmeeting")
    public String cancelmeeting(@RequestParam(name = "meetingid")Integer meetingid,
                                @RequestParam(name = "meetingname") String meetingname,Model model){
        model.addAttribute("meetingid",meetingid);
        model.addAttribute("meetingname",meetingname);
        return "cancelmeeting";
    }
    /**
     * 撤销会议的操作
     *
     * meetingid      会议id
     * canceledreason 撤销原因
     * 请求转发到mybookings页面
     */
    @PostMapping("/doCancel")
    public String doCancel(Integer meetingid ,String canceledreason){
        meetingService.cancelmeeting(meetingid,canceledreason);

        return "forward:mybookings";
    }
}
