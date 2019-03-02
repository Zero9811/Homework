package xin.zachary.homework.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xin.zachary.homework.daoimpl.TaskDAOImpl;
import xin.zachary.homework.entity.Task;
import xin.zachary.homework.service.TaskService;

import java.util.List;

@Service("taskService")
public class TaskServiceImpl extends BaseServiceImpl<Task> implements TaskService {

    @Autowired
    private TaskDAOImpl taskDAO;

    @Override
    @Transactional
    public List queryById(int id) {
        return taskDAO.queryById(id);
    }

    @Override
    @Transactional
    public List queryByTeacherUsername(String teacherUsername) {
        return taskDAO.queryByTeacherUsername(teacherUsername);
    }

    @Override
    @Transactional
    public List queryByStudentUsername(String studentUsername) {
        return taskDAO.queryByStudentUsername(studentUsername);
    }
}
