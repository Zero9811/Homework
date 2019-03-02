package xin.zachary.homework.service;

import xin.zachary.homework.entity.Task;

import java.util.List;

public interface TaskService extends BaseService<Task> {
    List queryById(int id);
    List queryByTeacherUsername(String teacherUsername);
    List queryByStudentUsername(String studentUsername);
}
