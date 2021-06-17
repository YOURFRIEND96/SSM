package com.abc.mybatis.dao;

import com.abc.mybatis.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> selectUser(Map<String, Integer> map);

    User selectUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

}
