package com.education.service;

import com.education.bean.Student;

import javax.servlet.http.HttpSession;

public interface StudentService {

    //注册
    Student register(String phone , int num , String password , String tpassword, HttpSession session);
    //学生短信登录
    Student dxlogin(String phone,int num,HttpSession session);
    //学生手机密码登录
    Student login(String phone,String password);
    int deleteByPrimaryKey(Integer sid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}