package xin.zachary.homework.dao;

import xin.zachary.homework.entity.Teacher;

import java.util.List;

public interface TeacherDAO extends BaseDAO<Teacher> {
    List queryByUsername(String username);
}
