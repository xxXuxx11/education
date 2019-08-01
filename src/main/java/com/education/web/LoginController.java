package com.education.web;

import com.education.bean.Teacher;
import com.education.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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




}
