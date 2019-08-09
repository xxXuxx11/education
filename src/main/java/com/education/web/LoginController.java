package com.education.web;

import com.education.bean.Student;
import com.education.bean.Teacher;
import com.education.service.StudentService;
import com.education.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
    public Map login(String phone, String password, HttpSession session, int type) {

        Map map=new HashMap();
        if (type == 1) {
            //type=1教师登录
            Teacher teacher = teacherService.login(phone, password);
            if (teacher == null) {
                map.put("code",1);
                map.put("msg","失败");
                map.put("data",teacher);
            } else {
                map.put("code",0);
                map.put("msg","成功");
                map.put("data",teacher);
                session.setAttribute("teacher",teacher);
            }
        }
        if (type == 2) {
            Student student = studentService.login(phone, password);
            if (student == null) {
                map.put("code",1);
                map.put("msg","失败");
                map.put("data",student);
            } else {
                map.put("code",0);
                map.put("msg","成功");
                map.put("data",student);
                session.setAttribute("student",student);
            }
        }
        return map;
    }



    //手机验证码登录
    @RequestMapping(method = RequestMethod.POST,value = "/user/teacher/dxlogin")
    @ResponseBody
    public Map dxlogin(String phone ,int num ,int type,HttpSession session){

        Map map=new HashMap();
        if (type == 1) {
            //type=1教师登录
            Teacher teacher = teacherService.dxlogin(phone, num, session);
            if (teacher != null) {
                map.put("code",0);
                map.put("msg","成功");
                map.put("data","短信登录成功");
                session.setAttribute("teacher",teacher);

            } else {
                map.put("code",1);
                map.put("msg","失败");
                map.put("data","短信登录失败");
            }
        }
        if (type == 2) {
            //type=1教师登录
            Student student = studentService.dxlogin(phone, num, session);
            if (student!=null) {
                map.put("code",0);
                map.put("msg","成功");
                map.put("data","短信登录成功");
                session.setAttribute("student",student);

            } else {
                map.put("code",1);
                map.put("msg","失败");
                map.put("data","短信登录失败");
            }
        }
        return map;
    }

//手机获取验证码
    @RequestMapping(method = RequestMethod.POST,value = "/yanzhengma")
    @ResponseBody
    public Map yanzhengma(HttpSession session,String phone){
        Map map=new HashMap();
        int  num  =new Random().nextInt(100000)+99999;
        session.setAttribute("num",num);
        session.setAttribute("phone",phone);
        boolean b = teacherService.yanzhengma( phone,num);
if(b){
    map.put("code",0);
    map.put("msg","成功");
    map.put("data","验证码发送成功");
}else {
    map.put("code",1);
    map.put("msg","失败");
    map.put("data","验证码发送失败");
}
        return map;
    }
    //教师注册用户
    @RequestMapping(method = RequestMethod.POST,value = "/teacher/register")
    @ResponseBody
    public Map teacherregister(String phone ,int num ,String password ,String tpassword,HttpSession session){
        Map map=new HashMap();
        Teacher teacher = teacherService.register(phone, num, password, tpassword, session);
        if (teacher!=null){
            map.put("code",0);
            map.put("msg","成功");
            map.put("data",teacher);
        }else {
            map.put("code",1);
            map.put("msg","失败");
            map.put("data",null);
        }
        return map;
    }
    //教师注册用户
    @RequestMapping(method = RequestMethod.POST,value = "/student/register")
    @ResponseBody
    public Map studentregister(String phone ,int num ,String password ,String tpassword,HttpSession session){
        Map map=new HashMap();
        Student student = studentService.register(phone, num, password, tpassword, session);
        if (student!=null){
            map.put("code",0);
            map.put("msg","成功");
            map.put("data",student);
        }else {
            map.put("code",1);
            map.put("msg","失败");
            map.put("data",null);
        }
        return map;
    }
    //用户修改密码
    @RequestMapping(method = RequestMethod.POST,value = "/changepassword")
    @ResponseBody
    public Map changepassword(String password,String tpassword,HttpSession session){
        Map map=new HashMap();
        String phone = (String)session.getAttribute("phone");



        return  map;
    }
}
