package xin.zachary.homework.dao;

import xin.zachary.homework.entity.Student;

import java.util.List;

public interface StudentDAO extends BaseDAO<Student> {
    List queryByUsername(String username);
    List queryByTaskId(int taskId);
    List queryUsernameById(int id);
}
