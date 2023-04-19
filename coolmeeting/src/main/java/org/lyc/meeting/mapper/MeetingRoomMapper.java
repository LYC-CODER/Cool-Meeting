package org.lyc.meeting.mapper;

import org.lyc.meeting.model.MeetingRoom;
import org.lyc.meeting.model.RoomDTO;

import java.util.List;

public interface MeetingRoomMapper {
    /**
     * 获取所有的会议室
     *
     * MeetingRoom
     */
    List<MeetingRoom> getAllMr();
    /**
     * 根据roomid获取对应的会议室
     *
     * roomid roomid
     * MeetingRoom
     */
     MeetingRoom getMrById(Integer roomid);
    /**
     * 更新会议房间信息
     *
     * meetingRoom MeetingRoom
     * Integer
     */
    Integer updateRoom(MeetingRoom meetingRoom);
    /**
     * 添加会议室操作
     *
     * meetingRoom MeetingRoom
     * Integer
     */
    Integer addMr(MeetingRoom meetingRoom);
    /**
     * 得到所有RoomDTO
     *
     * @return List<RoomDTO>
     */
    List<RoomDTO> getAll();
}
