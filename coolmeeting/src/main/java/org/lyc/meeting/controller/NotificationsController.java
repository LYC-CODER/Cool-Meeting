package org.lyc.meeting.controller;


import org.lyc.meeting.model.Employee;
import org.lyc.meeting.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * 通知页面
 */
@Controller
public class NotificationsController {
    @Autowired
    private MeetingService meetingService;
    /**
     * 返回到通知页面并把参加的会议列出来
     *
     * 返回到通知页面
     */
    @GetMapping("/notifications")
    public String notifications(Model model,HttpSession session){
        Employee currentuser = (Employee) session.getAttribute("currentuser");
        Integer employeeid = currentuser.getEmployeeid();
        model.addAttribute("ms",meetingService.getSevenDayMeeting(employeeid));
        model.addAttribute("cms",meetingService.getCancelMeeting());
        return "notifications";

    }
}
