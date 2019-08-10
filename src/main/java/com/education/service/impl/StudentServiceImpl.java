package com.education.service.impl;

import com.education.bean.Student;
import com.education.dao.StudentMapper;
import com.education.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@Service
public class StudentServiceImpl implements StudentService {
@Resource
private StudentMapper studentMapper;

    @Override
    public Student register(String phone, int num, String password, String tpassword, HttpSession session) {
        String duanxin = (String)session.getAttribute("num");
        String daunxin1=num+"";
        if (daunxin1.equals(duanxin)&&password.equals(tpassword)){
            Student student=new Student();
            student.setPhone(phone);
            student.setPassword(password);
            int i = studentMapper.insertSelective(student);
            int sid;
            if (i>0){
                sid=student.getSid();
                Student student1 = studentMapper.selectByPrimaryKey(sid);
                return student1;
            }
        }

        return null;

    }

    @Override
    public Student dxlogin(String phone, int num, HttpSession session) {
        //1.根据用户名查询信息
        Student student = studentMapper.login(phone);
        String duanxin = (String)session.getAttribute("num");
        String daunxin1=num+"";
        //2.验证短信验证码
        if (student!=null&&daunxin1.equals(duanxin)){
            return student;
        }
        return null;
    }

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
         return studentMapper.selectByPrimaryKey(sid);
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
