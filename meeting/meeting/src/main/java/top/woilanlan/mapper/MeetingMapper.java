package top.woilanlan.mapper;

import java.util.List;
import top.woilanlan.bean.Meeting;

public interface MeetingMapper {
    int deleteByPrimaryKey(Integer meetingid);

    int insert(Meeting record);

    Meeting selectByPrimaryKey(Integer meetingid);

    List<Meeting> selectAll();

    int updateByPrimaryKey(Meeting record);
}