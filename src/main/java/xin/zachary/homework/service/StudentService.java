package xin.zachary.homework.service;

import xin.zachary.homework.entity.Student;

import java.util.List;

public interface StudentService extends BaseService<Student> {
    List queryByUsername(String username);
    List queryByTaskId(int taskId);
    List queryUsernameById(int id);
}
