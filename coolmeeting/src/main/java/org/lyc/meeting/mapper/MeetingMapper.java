package org.lyc.meeting.mapper;

import org.apache.ibatis.annotations.Param;
import org.lyc.meeting.model.Meeting;
import org.lyc.meeting.model.MeetingDTO;

import java.util.List;

public interface MeetingMapper {
    /**
     * 添加会议
     *
     * meeting Meeting
     * Integer
     */
    Integer addMeeting(Meeting meeting);
    /**
     * 添加参与者
     *
     * meetingid 会议Id
     * mps       参加会议的员工的员工ID
     */
    void addParticipants(@Param("meetingid") Integer meetingid, @Param("mps") Integer[] mps);
    /**
     * 根据employeeid获取会议信息
     *
     * employeeid Integer
     * List<Meeting>
     */
    List<Meeting> getMeetingById(Integer employeeid);
    /**
     * 获取当前用户预订的会议
     *
     * employeeid Integer
     * List<MeetingDTO>
     */
    List<MeetingDTO> getmeetingofmybook(Integer employeeid);
    /*
     * 根据meetingid获取会议信息
     *
     * meetingid Integer
     * MeetingDTO
     */
    Meeting getMeetingByid(Integer meetingid);
    /**
     * 分页查询获得所有meeting
     *
     * meetingDTO MeetingDTO
     * page       页数
     * pagesize   查几条数据
     *
     */
    List<MeetingDTO> listMeetingDTOs(@Param("mdto") MeetingDTO meetingDTO,@Param("page") Integer page,@Param("pagesize") Integer pageSize);
    /**
     * 获取员工数量
     *
     * meetingDTO MeetingDTO
     * Long
     */
    Long getTotal(@Param("mdto") MeetingDTO meetingDTO);
    /**
     * 撤销会议的操作
     *
     * meetingid      会议id
     * canceledreason 撤销原因
     */
    void cancelmeeting(@Param("meetingid") Integer meetingid,@Param("canceledreason") String canceledreason);

    /**
     * 获得取消会议
     *
     * List<Meeting>
     */
    List<Meeting> getCancelMeeting();
}
