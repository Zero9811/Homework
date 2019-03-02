package xin.zachary.homework.dao;

import xin.zachary.homework.entity.Classes;

import java.util.List;

public interface ClassesDAO extends BaseDAO<Classes> {
    List queryById(int id);

    List queryAll();
}
