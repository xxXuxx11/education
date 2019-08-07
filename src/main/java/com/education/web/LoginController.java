package com.education.web;

import com.education.bean.Student;
import com.education.bean.Teacher;
import com.education.service.StudentService;
import com.education.service.TeacherService;
import com.education.util.DataView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
@Resource
private StudentService studentService;
@Resource
private TeacherService teacherService;

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
    public DataView<Teacher> login(String phone, String password, HttpSession session,int type) {
        DataView<Teacher> dataView = new DataView<>();
        //type=1教师登录
        if (type == 1) {
            Teacher teacher = teacherService.login(phone, password);
            if (teacher == null) {
                dataView.setCode(1);
                dataView.setMsg("失败");
                dataView.setData(null);

            } else {
                dataView.setCode(0);
                dataView.setMsg("成功");
                dataView.setData(null);

            }
        }
        if (type == 2) {
            Student student = studentService.login(phone, password);
            if (student == null) {
                dataView.setCode(1);
                dataView.setMsg("失败");
                dataView.setData(null);

            } else {
                dataView.setCode(0);
                dataView.setMsg("成功");
                dataView.setData(null);

            }

        }
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
