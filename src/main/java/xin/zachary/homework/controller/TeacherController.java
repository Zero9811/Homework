package xin.zachary.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xin.zachary.homework.entity.Student;
import xin.zachary.homework.entity.Task;
import xin.zachary.homework.entity.Teacher;
import xin.zachary.homework.serviceimpl.StudentServiceImpl;
import xin.zachary.homework.serviceimpl.TaskServiceImpl;
import xin.zachary.homework.serviceimpl.TeacherServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    private TeacherServiceImpl teacherService;
    @Autowired
    private StudentServiceImpl studentService;
    //学生和老师修改个人信息
    @RequestMapping(value = "/modifyInfo",method = RequestMethod.POST)
    public String modifyInfo(HttpSession session, String name,String gender,int age){
        if(session.getAttribute("usertype").equals("teacher")) {
                Teacher queryTeacher = (Teacher) teacherService.queryByUsername((String) session.
                        getAttribute("username")).get(0);
                queryTeacher.setAge(age);
                queryTeacher.setGender(gender);
                queryTeacher.setName(name);
                teacherService.update(queryTeacher);
                return "success";
        }
        else {
            Student queryStudent = (Student) studentService.queryByUsername((String) session.
                    getAttribute("username")).get(0);
            queryStudent.setAge(age);
            queryStudent.setGender(gender);
            queryStudent.setName(name);
            studentService.update(queryStudent);
            return "success";
        }
    }
}
