package top.woilanlan.mapper;

import java.util.List;
import top.woilanlan.bean.MeetingRoom;

public interface MeetingRoomMapper {
    int deleteByPrimaryKey(Integer roomid);

    int insert(MeetingRoom record);

    MeetingRoom selectByPrimaryKey(Integer roomid);

    List<MeetingRoom> selectAll();

    int updateByPrimaryKey(MeetingRoom record);
}