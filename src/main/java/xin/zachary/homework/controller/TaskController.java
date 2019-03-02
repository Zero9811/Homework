package xin.zachary.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xin.zachary.homework.entity.Task;
import xin.zachary.homework.serviceimpl.TaskServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskServiceImpl taskService;

    //老师创建一个任务
    @RequestMapping(value = "/createTask",method = RequestMethod.POST)
    public String createTask(Task task, HttpSession session){
        if(taskService.queryById(task.getId()).size()==0){
            task.setDate(new Date());
            task.setTeacherUsername((String) session.getAttribute("username"));
            taskService.save(task);
            return "success";
        }
        else
            return "createTask";
    }

    //查询任务，返回任务集合
    @RequestMapping(value = "/queryTask",method = RequestMethod.GET)
    public String queryTask(HttpSession session, Model model){
        //老师查询
        if(session.getAttribute("usertype").equals("teacher")){
            List list = taskService.queryByTeacherUsername((String) session.getAttribute("username"));
            model.addAttribute("task_list",list);
            return "task_query_success";
        }
        else if(session.getAttribute("usertype").equals("student")){
            List list = taskService.queryByStudentUsername((String) session.getAttribute("username"));
            model.addAttribute("task_list",list);
            return "task_query_success";
        }
        else
            return "error";
    }

    @RequestMapping(value = "/deleteTask",method = RequestMethod.GET)
    public String deleteTask(HttpSession session,int taskId){
        if(session.getAttribute("usertype").equals("teacher")){
            Task task = (Task) taskService.queryById(taskId).get(0);
            taskService.delete(task);
            return "forward:/queryTask";
        }
        else
            return "redirect:/queryTask";
    }
}
