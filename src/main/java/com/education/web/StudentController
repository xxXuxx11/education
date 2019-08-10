package com.education.web;

import com.education.bean.Student;
import com.education.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedHashMap;

@Controller
public class StudentController {
    @Resource
    private StudentService studentService;

     @RequestMapping("/student/selectall")
     @ResponseBody
     HashMap selectByPrimaryKey(Integer sid) {
         LinkedHashMap ret = new LinkedHashMap();
         //ret.put("code",0);
         try {
             Student student = studentService.selectByPrimaryKey(sid);
             ret.put("code",0);
             ret.put("msg","成功");
             ret.put("data",student);

         }catch (Exception e){
             ret.put("code",1);
             ret.put("msg","sid必传且大于0");
             ret.put("data","失败");

         }
         return ret;
    }



}
