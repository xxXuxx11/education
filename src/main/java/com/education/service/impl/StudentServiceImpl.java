package com.education.service.impl;

import com.education.bean.Student;
import com.education.dao.StudentMapper;
import com.education.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class StudentServiceImpl implements StudentService {
@Resource
private StudentMapper studentMapper;

    @Override
    public Student login(String phone, String password) {

        //1.根据用户名查询信息
        Student student = studentMapper.login(phone);
        //2.验证密码
        if (student!=null&&password.equals(student.getPassword())) {
            return student;
        }
        return null;
    }

    @Override
    public int deleteByPrimaryKey(Integer sid) {
        return 0;
    }

    @Override
    public int insert(Student record) {
        return 0;
    }

    @Override
    public int insertSelective(Student record) {
        return 0;
    }

    @Override
    public Student selectByPrimaryKey(Integer sid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Student record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return 0;
    }
}
