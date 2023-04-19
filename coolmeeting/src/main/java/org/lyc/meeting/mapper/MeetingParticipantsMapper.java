package org.lyc.meeting.mapper;

import java.util.List;

public interface MeetingParticipantsMapper {
    /*
     * 通过meetingid获取参加会议的人的employeeid
     *
     * meetingid Integer
     * List<Integer>
     */
List<Integer> getAllBymeetingid(Integer meetingid);
}
