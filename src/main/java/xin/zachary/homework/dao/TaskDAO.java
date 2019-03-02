package xin.zachary.homework.dao;

import xin.zachary.homework.entity.Task;

import java.util.List;

public interface TaskDAO extends BaseDAO<Task> {
    List queryById(int id);
    List queryByTeacherUsername(String teacherUsername);
    List queryByStudentUsername(String studentUsername);
}
