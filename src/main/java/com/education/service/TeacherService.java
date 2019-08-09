package com.education.service;

import com.education.bean.Teacher;

import javax.servlet.http.HttpSession;

public interface TeacherService {
    //修改密码
    int changepassword(String phone,String password,String tpassword,HttpSession session);
    //注册
    Teacher register(String phone ,int num ,String password ,String tpassword,HttpSession session);
    //获取验证码
    public boolean yanzhengma( String phone,int num);
    //老师手机密码登录
    Teacher login(String phone,String password);
    //老师手机验证码登录
    Teacher dxlogin(String phone, int num, HttpSession session);
    int deleteByPrimaryKey(Integer tid);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}