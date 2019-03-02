package xin.zachary.homework.service;

import xin.zachary.homework.entity.Teacher;

import java.util.List;

public interface TeacherService extends BaseService<Teacher> {
    List queryByUsername(String username);
}
