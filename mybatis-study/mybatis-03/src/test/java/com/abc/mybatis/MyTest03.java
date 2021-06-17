package com.abc.mybatis;

import com.abc.mybatis.dao.BlogDao;
import com.abc.mybatis.entity.Blog;
import com.abc.mybatis.util.IDUtil;
import com.abc.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;

public class MyTest03 {

    @Test
    public void addInitBlog() {
        SqlSession session = MybatisUtil.getSqlSession();
        BlogDao blogDao = session.getMapper(BlogDao.class);

        Blog blog = new Blog();
        blog.setId(IDUtil.generateID());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        blogDao.addBlog(blog);

        blog.setId(IDUtil.generateID());
        blog.setTitle("Java如此简单");
        blogDao.addBlog(blog);

        blog.setId(IDUtil.generateID());
        blog.setTitle("Spring如此简单");
        blogDao.addBlog(blog);

        blog.setId(IDUtil.generateID());
        blog.setTitle("微服务如此简单");
        blogDao.addBlog(blog);

        session.close();
    }

}
