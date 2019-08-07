package com.education.service.impl;

import com.education.bean.Teacher;
import com.education.dao.TeacherMapper;
import com.education.service.TeacherService;

import javax.annotation.Resource;

public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public Teacher login(String phone, String password) {

        //1.根据用户名查询信息
        Teacher teacher = teacherMapper.login(phone);
        //2.验证密码
        if (teacher!=null&&password.equals(teacher.getPassword())) {
            return teacher;
        }
        return null;
    }

    @Override
    public int deleteByPrimaryKey(Integer tid) {
        return 0;
    }

    @Override
    public int insert(Teacher record) {
        return 0;
    }

    @Override
    public int insertSelective(Teacher record) {
        return 0;
    }

    @Override
    public Teacher selectByPrimaryKey(Integer tid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Teacher record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Teacher record) {
        return 0;
    }
}
