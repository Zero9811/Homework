package xin.zachary.homework.controller;
/**
 * 用户的主要操作，能注册、登录、登出
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import xin.zachary.homework.entity.Student;
import xin.zachary.homework.entity.Teacher;
import xin.zachary.homework.entity.User;
import xin.zachary.homework.serviceimpl.StudentServiceImpl;
import xin.zachary.homework.serviceimpl.TeacherServiceImpl;
import xin.zachary.homework.serviceimpl.UserServiceImpl;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    StudentServiceImpl studentService;

    @Autowired
    TeacherServiceImpl teacherService;

    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public String login(User user, HttpSession session){
        System.out.println("进行验证");
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getUsertype());

        List list = userService.queryByUsername(user.getUsername());
        if (list.size()==0){
            return "login";
        }
        User user1 = (User) list.get(0);
        if(user.getPassword().equals(user1.getPassword()) && user.getUsertype().equals(user1.getUsertype())){
            session.setAttribute("username",user.getUsername());
            session.setAttribute("usertype",user.getUsertype());
            return "main";
        }
        else
            return "login";
    }

    @RequestMapping(value = "/doRegister",method = RequestMethod.POST)
    public String register(User user,String password2){
        System.out.println("测试读到的注册信息");
        System.out.println(password2);
        //密码不相同
        if(!user.getPassword().equals(password2))
            return "register";
        //用户已经存在
        if(userService.queryByUsername(user.getUsername()).size()!=0)
            return "register";

        userService.save(user);
        //学生老师不同的类型
        if(user.getUsertype().equals("student")){
            Student student = new Student();
            student.setUsername(user.getUsername());
            student.setAge(0);
            student.setClassId(0);
            studentService.save(student);
        }
        else if(user.getUsertype().equals("teacher")){
            Teacher teacher = new Teacher();
            teacher.setUsername(user.getUsername());
            teacher.setAge(0);
            teacherService.save(teacher);
        }
        return "login";
    }

    //删除session中存储的登录信息，返回主页
    @RequestMapping(value = "/doLogout",method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.removeAttribute("username");
        session.removeAttribute("usertype");
        return "index";
    }
}
