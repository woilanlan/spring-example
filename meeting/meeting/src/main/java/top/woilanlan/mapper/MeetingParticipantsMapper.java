package top.woilanlan.mapper;

import java.util.List;
import top.woilanlan.bean.MeetingParticipants;

public interface MeetingParticipantsMapper {
    int insert(MeetingParticipants record);

    List<MeetingParticipants> selectAll();
}