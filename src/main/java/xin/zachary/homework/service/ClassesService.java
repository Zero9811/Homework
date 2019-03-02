package xin.zachary.homework.service;

import xin.zachary.homework.entity.Classes;

import java.util.List;

public interface ClassesService extends BaseService<Classes> {
    List queryById(int id);
    List queryAll();
}
