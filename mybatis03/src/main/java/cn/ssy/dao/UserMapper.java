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

    List<User> Fuzzyquery(String word);

    //分页查询
    List<User> getUserByLimit(Map<String,Integer> map);
}
