package cn.ssy.dao;

import cn.ssy.pojo.User;
import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getuserlist();

    User getUserById(int id);

    boolean deleteUserById(int id);

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean updateUser2(Map<String,Object>map);

    boolean addUser2(Map<String,Object> map);

    List<User> Fuzzyquery (String word);
}
