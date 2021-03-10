package cn.ssy.dao;

import cn.ssy.pojo.User;
import java.util.List;

public interface UserMapper {
    List<User> getuserlist();

    User getUserById(int id);

    boolean deleteUserById(int id);

    boolean addUser(User user);

    boolean updateUser(User user);
}
