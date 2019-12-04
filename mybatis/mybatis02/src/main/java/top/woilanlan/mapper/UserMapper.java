package top.woilanlan.mapper;

import org.apache.ibatis.annotations.Param;
import top.woilanlan.bean.User;
import top.woilanlan.bean.UserWrapper;

import java.util.HashMap;
import java.util.List;

public interface UserMapper {
    /*
    使用${id}的话，要在这里设置
    User getUserById(@Param("id") Integer id);
     */
    User getUserById(Integer id);

    Long getCount();

    int addUser(User user);

    List<User> getUsersByPage(@Param("start") Integer start,@Param("count") Integer count);

    int addUser2(UserWrapper uw);

    int addUser3(HashMap<String,Object> map);

    HashMap<String,Object> getUserById2(Integer id);
}
