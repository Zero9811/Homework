package xin.zachary.homework.service;

import xin.zachary.homework.entity.Grades;

import java.util.List;

public interface GradesService extends BaseService<Grades> {
    List queryExists(String studentUsername,int taskId);
    List queryByTaskId(int taskId);
}
