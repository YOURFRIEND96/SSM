package com.abc.dao;

import com.abc.mybatis.dao.UserDao;
import com.abc.mybatis.entity.User;
import com.abc.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void testSelectUser() {
        SqlSession session = MybatisUtil.getSqlSession();

        UserDao userDao = session.getMapper(UserDao.class);
        List<User> users = userDao.selectUser();
        for (User user: users) {
            System.out.println(user);
        }
        session.close();
    }

    @Test
    public void testSelectUserById()
    {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.selectUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testAddUser()
    {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User(4,"wangwu","123456");
        int i = userDao.addUser(user);
        System.out.println(i);
        // 增删改操作需要提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate()
    {
        SqlSession session = MybatisUtil.getSqlSession();
        UserDao userDao = session.getMapper(UserDao.class);
        User user = userDao.selectUserById(1);
        user.setPwd("qazwsx");
        int i = userDao.updateUser(user);
        System.out.println(i);
        session.commit();
        session.close();
    }

    @Test
    public void testDelete()
    {
        SqlSession session = MybatisUtil.getSqlSession();
        UserDao userDao = session.getMapper(UserDao.class);
        int i = userDao.deleteUser(4);
        System.out.println(i);
        session.commit();
        session.close();
    }
}
