package com.abc.mybatis;

import com.abc.mybatis.dao.StudentDao;
import com.abc.mybatis.dao.TeacherDao;
import com.abc.mybatis.entity.Student;
import com.abc.mybatis.entity.Teacher;
import com.abc.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


public class Mytest {

    @Test
    public void testGetTeacher()
    {
        SqlSession session = MybatisUtil.getSqlSession();
        TeacherDao teacherDao = session.getMapper(TeacherDao.class);
        Teacher teacher = teacherDao.getTeacher(1);
        System.out.println(teacher);

        session.close();
    }

    @Test
    public void testGetStudents()
    {
        SqlSession session = MybatisUtil.getSqlSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);

        List<Student> students = studentDao.getStudents();

        for (Student s : students) {
            System.out.println(
                    "学生： " + s.getName() + "\t老师： "+s.getTeacher().getName()
            );
        }
        session.close();
    }

}
