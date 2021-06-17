package com.abc.mybatis.dao;

import com.abc.mybatis.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherDao {

    @Select("select * from teacher where id=#{tid}")
     Teacher getTeacher(@Param("tid") Integer id);

}
