package xin.zachary.homework.dao;

import xin.zachary.homework.entity.Grades;

import java.util.List;

public interface GradesDAO extends BaseDAO<Grades> {
    List queryExists(String studentUsername,int taskId);
    List queryByTaskId(int taskId);
}
