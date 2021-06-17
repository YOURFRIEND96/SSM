package com.abc.mybatis.entity;

import lombok.Data;

@Data
public class Student {

    private Integer id;
    private String name;
    private Teacher teacher;

}
