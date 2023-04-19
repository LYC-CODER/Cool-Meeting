package org.lyc.meeting.service;

import org.lyc.meeting.mapper.MeetingMapper;
import org.lyc.meeting.mapper.MeetingRoomMapper;
import org.lyc.meeting.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MeetingService {
    @Autowired
    private MeetingMapper meetingMapper;
    @Autowired
    private MeetingRoomMapper meetingRoomMapper;

    /**
     * 增加会议
     * <p>
     * meeting Meeting
     * mps     参加会议的员工的员工ID
     * Integer
     */
    public Integer addMeeting(Meeting meeting, Integer[] mps) {
        //会议发起的时间
        meeting.setReservationtime(new Date());
        Integer result = meetingMapper.addMeeting(meeting);
        meetingMapper.addParticipants(meeting.getMeetingid(), mps);
        return result;
    }

    /*
     * 获取当前用户预订的会议
     *
     * employeeid Integer
     * List<MeetingDTO>
     */
    public List<MeetingDTO> getmeetingofmybookCanCancle(Integer employeeid) {
        return meetingMapper.getmeetingofmybook(employeeid);
    }

    /**
     * 根据meetingid获取会议信息
     * <p>
     * meetingid Integer
     * MeetingDTO
     */
    public Meeting getmeetingByid(Integer meetingid) {
        return meetingMapper.getMeetingByid(meetingid);
    }

    /**
     * 分页查询获得所有meeting
     * <p>
     * meetingDTO MeetingDTO
     * page       页数
     * pagesize   查几条数据
     */
    public List<MeetingDTO> listMeetingDTOs(MeetingDTO meetingDTO, Integer page, Integer pageSize) {
        page = (page - 1) * pageSize;
        return meetingMapper.listMeetingDTOs(meetingDTO, page, pageSize);
    }

    /**
     * 获取员工数量
     * <p>
     * meetingDTO MeetingDTO
     * Long
     */
    public Long getTotal(MeetingDTO meetingDTO) {
        return meetingMapper.getTotal(meetingDTO);
    }

    /**
     * 撤销会议的操作
     * <p>
     * meetingid      会议id
     * canceledreason 撤销原因
     */
    public void cancelmeeting(Integer meetingid, String canceledreason) {
        meetingMapper.cancelmeeting(meetingid, canceledreason);
    }

    /**
     * 参加七日会议
     * <p>
     * employeeid Integer
     * List<SevenDayMeeting>
     */
    public List<SevenDayMeeting> getSevenDayMeeting(Integer employeeid) {
        List<Meeting> list = meetingMapper.getMeetingById(employeeid);
        List<RoomDTO> listroomDTO = meetingRoomMapper.getAll();
        //
        Calendar c = Calendar.getInstance();
        Date now = new Date();
        c.setTime(now);
        c.add(Calendar.DATE, 7);
        Date after7day = c.getTime();
        //过滤 得到未来7天内需要我的会议
        List<Meeting> listNext7day = list.stream().filter(s -> s.getStarttime().getTime() >= now.getTime() &&
                s.getStarttime().getTime() <= after7day.getTime()).collect(Collectors.toList());

        //得到Map<roomid,roomname>方便下面转换,添加对应的roomname
        Map<Integer, String> resultMap = listroomDTO.stream().collect(Collectors.toMap
                (RoomDTO::getRoomid, RoomDTO::getRoomname));

        //转换Meeting为SevenDayMeeting,更好的在View展示,补充Meeting缺失的属性
        List<SevenDayMeeting> listDto = listNext7day.stream().map(meeting -> {

            SevenDayMeeting sevenDayMeeting = new SevenDayMeeting();

            BeanUtils.copyProperties(meeting, sevenDayMeeting);

            sevenDayMeeting.setRoomname(resultMap.get(meeting.getRoomid()));

            return sevenDayMeeting;
        }).collect(Collectors.toList());
        return listDto;
        /*
         * 获得取消会议
         *
         * List<CancelMeeting>
         */
    }

    public List<CancelMeeting> getCancelMeeting() {
        List<Meeting> list = meetingMapper.getCancelMeeting();
        List<RoomDTO> listroomDTO = meetingRoomMapper.getAll();

        //得到Map<roomid,roomname>方便下面转换,添加对应的roomname
        Map<Integer, String> resultMap = listroomDTO.stream().collect(Collectors.toMap(
                RoomDTO::getRoomid, RoomDTO::getRoomname
        ));

        //转换Meeting为CancelMeeting,更好的在View展示,补充Meeting缺失的属性
        List<CancelMeeting> listDto = list.stream().map(meeting -> {

            CancelMeeting cancelMeeting = new CancelMeeting();

            BeanUtils.copyProperties(meeting, cancelMeeting);

            cancelMeeting.setRoomname(resultMap.get(meeting.getRoomid()));

            return cancelMeeting;
        }).collect(Collectors.toList());
        return listDto;
    }
}

