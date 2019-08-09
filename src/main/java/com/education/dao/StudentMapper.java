package com.education.dao;

import com.education.bean.Student;


public interface StudentMapper {
    int changpassword(String phone,String password);
    Student findall(int sid);
    Student login(String phone);
    int deleteByPrimaryKey(Integer sid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}