package xin.zachary.homework.service;

import xin.zachary.homework.entity.TeacherHomework;

import java.util.List;

public interface TeacherHomeworkService extends BaseService<TeacherHomework> {
    List queryByName(String name);
}
