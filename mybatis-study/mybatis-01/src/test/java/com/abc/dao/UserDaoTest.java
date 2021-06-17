package com.abc.dao;

import com.abc.mybatis.dao.UserDao;
import com.abc.mybatis.entity.User;
import com.abc.mybatis.util.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    @Test
    public void testSelectUser() {
        SqlSessionFactory sqlSessionFactory = null;
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSession session = sqlSessionFactory.openSession();
        UserDao userDao = session.getMapper(UserDao.class);
        int curPage = 1;
        int pageSize = 2;
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex", (curPage - 1) * pageSize);
        map.put("pageSize", pageSize);
        List<User> users = userDao.selectUser(map);
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
