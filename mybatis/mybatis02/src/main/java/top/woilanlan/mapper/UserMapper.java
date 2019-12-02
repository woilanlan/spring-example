package top.woilanlan.mapper;

import top.woilanlan.bean.User;

public interface UserMapper {
    User getUserById(Integer id);

    Long getCount();

    int addUser(User user);
}
