package com.education.dao;

import com.education.bean.Teacher;

public interface TeacherMapper {
    int changpassword(String phone,String password);

    Teacher findall(int tid);
    Teacher login(String phone);
    int deleteByPrimaryKey(Integer tid);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}