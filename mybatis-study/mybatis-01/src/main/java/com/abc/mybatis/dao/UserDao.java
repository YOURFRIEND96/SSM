package com.abc.mybatis.dao;

import com.abc.mybatis.entity.User;

import java.util.List;

public interface UserDao {
    List<User> selectUser();

    User selectUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
