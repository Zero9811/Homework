package xin.zachary.homework.dao;

import xin.zachary.homework.entity.TeacherHomework;

import java.util.List;

public interface TeacherHomeworkDAO extends BaseDAO<TeacherHomework> {
    List queryByName(String name);
}
