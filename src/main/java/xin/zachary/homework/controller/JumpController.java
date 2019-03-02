package xin.zachary.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xin.zachary.homework.entity.Student;
import xin.zachary.homework.entity.Teacher;
import xin.zachary.homework.serviceimpl.StudentServiceImpl;
import xin.zachary.homework.serviceimpl.TeacherServiceImpl;

import javax.servlet.http.HttpSession;

@Controller
public class JumpController {
    @Autowired
    private TeacherServiceImpl teacherService;
    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping(value = "/jumpLogin",method = RequestMethod.GET)
    public String jumpLogin(){
        System.out.println("执行到这里了吗");
        return "login";
    }
    //注册页面
    @RequestMapping(value = "/jumpRegister",method = RequestMethod.GET)
    public String jumpRegister(){
        return "register";
    }

    //个人中心
    @RequestMapping(value = "/jumpPersonalCenter",method = RequestMethod.GET)
    public String jumpPersonalCenter(HttpSession session){
        if(session.getAttribute("username")!=null && session.getAttribute("usertype").equals("student"))
            return "student_personal_center";
        else if (session.getAttribute("username")!=null && session.getAttribute("usertype").equals("teacher"))
            return "teacher_personal_center";
        else
            return "main";
    }

    //个人信息
    @RequestMapping(value = "/jumpPersonalInfo",method = RequestMethod.GET)
    public String jumpPersonalInfo(HttpSession session,Model model){
        if(session.getAttribute("usertype").equals("teacher")){
            Teacher teacher = (Teacher) teacherService.queryByUsername((String) session.
                    getAttribute("username")).get(0);
            model.addAttribute("info",teacher);
            return "personalInfo";
        }
        else {
            Student student = (Student) studentService.queryByUsername((String) session.
                    getAttribute("username")).get(0);
            model.addAttribute("info",student);
            return "personalInfo";
        }
    }

    //创建任务
    @RequestMapping(value = "/jumpCreateTask",method = RequestMethod.GET)
    public String jumpCreateTask(){
        return "createTask";
    }

    //创建班级
    @RequestMapping(value = "/jumpCreateClass",method = RequestMethod.GET)
    public String jumpCreateClass(){
        return "createClass";
    }

    //上传页面
    @RequestMapping(value = "/jumpUpload",method = RequestMethod.GET)
    public String jumpUpload(int taskId, Model model){
        System.out.println("测试taskName "+taskId);
        model.addAttribute("taskId",taskId);
        return "uploadFile";
    }
}
