package xin.zachary.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xin.zachary.homework.entity.Grades;
import xin.zachary.homework.entity.Mistakes;
import xin.zachary.homework.serviceimpl.GradesServiceImpl;
import xin.zachary.homework.serviceimpl.MistakesServiceImpl;
import xin.zachary.homework.serviceimpl.StudentServiceImpl;
import xin.zachary.homework.serviceimpl.TaskServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class GradeController {

    @Autowired
    private TaskServiceImpl taskService;
    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private GradesServiceImpl gradesService;
    @Autowired
    private MistakesServiceImpl mistakesService;

    //从session中获取用户数据，得到用户的任务名称
    @RequestMapping(value = "/jumpGradeTask",method = RequestMethod.GET)
    public String jumpTask(HttpSession session, Model model){
        System.out.println("进入jumpGradeTask");
        if(session.getAttribute("usertype").equals("teacher")){
            System.out.println("进入老师查看作业");
            List list = taskService.queryByTeacherUsername((String) session.getAttribute("username"));
            model.addAttribute("task_list",list);
            System.out.println("任务的大小: "+list);
            return "grade_task_list_teacher";
        }
        else if (session.getAttribute("usertype").equals("student")){
            List list = taskService.queryByStudentUsername((String) session.getAttribute("username"));
            model.addAttribute("task_list",list);
            return "grade_task_list_student";
        }
        else return null;
    }

    @RequestMapping(value = "/jumpGradesAdd",method = RequestMethod.GET)
    public String jumpGradesAdd(Model model,int taskId){
        //获取一次任务的所有学生的用户名集合
        List studentList = studentService.queryByTaskId(taskId);
        model.addAttribute("studentList",studentList);
        model.addAttribute("taskId",taskId);
        return "addGrades";
    }
    @RequestMapping(value = "/addGrade")
    public String addGrades(Model model, Grades grade){
        System.out.println(grade.toString());
        //查询该生该任务的成绩是否存在
        List list = gradesService.queryExists(grade.getStudentUsername(),grade.getTaskId());
        if(list.size()==0){
            grade.setCalculateGrade();
            System.out.println("学生成绩："+grade.getGrade());
            System.out.println(grade.toString());
            gradesService.save(grade);
            //然后记录错误
            Mistakes mistakes1 = new Mistakes();
            mistakes1.setStudentUsername(grade.getStudentUsername());
            mistakes1.setTaskId(grade.getTaskId());
            mistakes1.setMultipleChoice(20-grade.getMultipleChoice());
            mistakes1.setClozeTest(30-grade.getClozeTest());
            mistakes1.setReadingComprehension(50-grade.getReadingComprehension());
            mistakes1.setErrorCorrection(15-grade.getErrorCorrection());
            mistakes1.setComposition(35-grade.getComposition());
            mistakes1.setDate(new Date());
            System.out.println(mistakes1.toString());
            mistakesService.save(mistakes1);
        }
        else {
            grade.setCalculateGrade();
            Grades queryGrades = (Grades) list.get(0);
            queryGrades.setMultipleChoice(grade.getMultipleChoice());
            queryGrades.setClozeTest(grade.getClozeTest());
            queryGrades.setReadingComprehension(grade.getReadingComprehension());
            queryGrades.setErrorCorrection(grade.getErrorCorrection());
            queryGrades.setComposition(grade.getComposition());
            queryGrades.setGrade(grade.getGrade());
            gradesService.update(queryGrades);
            grade = queryGrades;
            //然后记录错误
            Mistakes mistakes1 = (Mistakes) mistakesService.queryOneMistake(grade.getStudentUsername(),grade.getTaskId()).get(0);
            mistakes1.setMultipleChoice(20-grade.getMultipleChoice());
            mistakes1.setClozeTest(30-grade.getClozeTest());
            mistakes1.setReadingComprehension(50-grade.getReadingComprehension());
            mistakes1.setErrorCorrection(15-grade.getErrorCorrection());
            mistakes1.setComposition(35-grade.getComposition());
            mistakes1.setDate(new Date());
            mistakesService.save(mistakes1);
        }
        model.addAttribute("taskId",grade.getTaskId());
        return "addGrades";
    }
    @RequestMapping(value = "/showGrades",method = RequestMethod.GET)
    public String showGrades(Model model,int taskId,HttpSession session){
        if(session.getAttribute("usertype").equals("teacher")) {
            List gradesList = gradesService.queryByTaskId(taskId);
            model.addAttribute("grades_list", gradesList);
            return "showGrades";
        }
        else {
            List gradeList = gradesService.queryExists((String) session.getAttribute("username"),taskId);
            model.addAttribute("grades_list", gradeList);
            return "showGrades";
        }
    }
}
