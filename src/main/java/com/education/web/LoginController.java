package com.education.web;

import com.education.bean.Teacher;
import com.education.service.StudentService;
import com.education.util.DataView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class LoginController {
@Resource
private StudentService studentService;

    @RequestMapping("/test1")
    @ResponseBody
    public Teacher test(){
        Teacher teacher=new Teacher();
        teacher.setTname("王老师");
        teacher.setTage(35);
        System.out.println("git");
        return teacher;
    }
    //手机密码登录
    @RequestMapping(method = RequestMethod.POST,value = "/user/teacher/login")
    @ResponseBody
    public DataView<Teacher> login(){
        DataView<Teacher> dataView=new DataView<>();



        return dataView;
    }



    //手机验证码登录
    @RequestMapping(method = RequestMethod.POST,value = "/user/teacher/dxlogin")
    @ResponseBody
    public DataView<Teacher> dxlogin(){
        DataView<Teacher> dataView=new DataView<>();

        return dataView;
    }


}
