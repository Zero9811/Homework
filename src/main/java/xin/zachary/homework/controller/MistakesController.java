package xin.zachary.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xin.zachary.homework.serviceimpl.MistakesServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MistakesController {

    @Autowired
    private MistakesServiceImpl mistakesService;

    //查找一个学生的所有错误
    @RequestMapping(value = "/studentQueryMistakes")
    public String studentQueryMistakes(HttpSession session,Model model){
        List list = mistakesService.queryByStudentUsername((String) session.getAttribute("username"));
        model.addAttribute("mistakes_list",list);
        return "student_show_mistakes";
    }

    //老师查找错误，从session中获取老师的用户名，
    public String teacherQueryMistakes(HttpSession session,Model model){
        return "teacher_show_mistakes";
    }
}
