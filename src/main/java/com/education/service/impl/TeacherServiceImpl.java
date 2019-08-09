package com.education.service.impl;

import com.education.bean.Teacher;
import com.education.dao.TeacherMapper;
import com.education.service.TeacherService;
import com.education.util.yunpian.sdk.TestSms;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherMapper teacherMapper;

    @Override
    @Transactional
    public int changepassword(String phone, String password, String tpassword, HttpSession session) {
        if (password.equals(tpassword)) {
            int i = teacherMapper.changpassword(phone, password);
              
        }

        return 0;
    }

    @Override
    @Transactional
    public Teacher register(String phone, int num, String password, String tpassword,HttpSession session) {
        String duanxin = (String)session.getAttribute("num");
        String daunxin1=num+"";
if (daunxin1.equals(duanxin)&&password.equals(tpassword)){
    Teacher teacher=new Teacher();
    teacher.setPhone(phone);
    teacher.setPassword(password);
    int i = teacherMapper.insertSelective(teacher);
    int tid;
    if (i>0){
        tid=teacher.getTid();
        Teacher teacher1 = teacherMapper.selectByPrimaryKey(tid);
        return teacher1;
    }
}

        return null;
    }

    @Override
    public Teacher dxlogin(String phone, int num, HttpSession session) {
        //1.根据用户名查询信息
        Teacher teacher = teacherMapper .login(phone);
        String duanxin = (String)session.getAttribute("num");
        String daunxin1=num+"";
        //2.验证短信验证码
        if (teacher!=null&&daunxin1.equals(duanxin)){
            return teacher;
        }
        return null;
    }

    @Override
    public boolean yanzhengma(String phone,int num){

        TestSms testSmsApi=new TestSms();
        boolean b = testSmsApi.single_sendTest(num, phone);
        return b;
    }
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
