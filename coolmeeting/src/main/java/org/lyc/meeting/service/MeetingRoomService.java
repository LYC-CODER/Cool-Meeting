package org.lyc.meeting.service;

import org.lyc.meeting.mapper.MeetingRoomMapper;
import org.lyc.meeting.model.MeetingRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MeetingRoomService {
    @Autowired
    MeetingRoomMapper meetingRoomMapper;
    /**
     * 得到所有的会议室
     *
     * MeetingRoom
     */
    public List<MeetingRoom> getAllMr() {
        return meetingRoomMapper.getAllMr();
    }
    /**
     * 根据roomid获取对应的会议室
     *
     * roomid roomid
     * MeetingRoom
     */
    public MeetingRoom getMrById(Integer roomid) {

        return meetingRoomMapper.getMrById(roomid);
    }
    /**
     * 更新会议房间信息
     *
     *  meetingRoom MeetingRoom
     *  Integer
     */
    public Integer updateRoom(MeetingRoom meetingRoom) {
        return meetingRoomMapper.updateRoom(meetingRoom);
    }
     /** 添加会议室操作
     *
     *  meetingRoom MeetingRoom
     *  Integer
     */
    public Integer addMr(MeetingRoom meetingRoom) {
        return meetingRoomMapper.addMr(meetingRoom);
    }

}
