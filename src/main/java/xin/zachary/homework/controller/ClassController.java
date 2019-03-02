package xin.zachary.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xin.zachary.homework.entity.Classes;
import xin.zachary.homework.entity.Student;
import xin.zachary.homework.serviceimpl.ClassesServiceImpl;
import xin.zachary.homework.serviceimpl.StudentServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class ClassController {

    @Autowired
    private ClassesServiceImpl classesService;

    @Autowired
    private StudentServiceImpl studentService;

    //创建班级
    @RequestMapping(value = "/createClass",method = RequestMethod.POST)
    public String createClass(Classes classes, HttpSession session){
        if(classesService.queryById(classes.getId()).size()==0){
            classes.setDate(new Date());
            classes.setTeacherUsername((String) session.getAttribute("username"));
            classesService.save(classes);
            return "success";
        }
        else
            return "createClass";
    }

    //学生加入班级,传入班级id，暂时未考虑学生已经有班级的情况
    @RequestMapping(value = "/joinClass",method = RequestMethod.GET)
    public String joinClass(int classId,HttpSession session){
        Student student = (Student) studentService.queryByUsername((String) session.getAttribute("username")).get(0);
        student.setClassId(classId);
        studentService.update(student);

        //班级学生人数加1
        Classes classes = (Classes) classesService.queryById(classId).get(0);
        classes.setStudentNumbers(classes.getStudentNumbers()+1);
        classesService.update(classes);

        return "success";
    }

    //学生查询班级
    @RequestMapping(value = "/queryClass",method = RequestMethod.GET)
    public String queryClass(Model model){
        List list = classesService.queryAll();
        model.addAttribute("class_list",list);
        return "class_query_success";
    }
}
