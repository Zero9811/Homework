package xin.zachary.homework.service;

import xin.zachary.homework.entity.Mistakes;

import java.util.List;

public interface MistakesService extends BaseService<Mistakes> {
    List queryByStudentUsername(String username);
    List queryOneMistake(String studentUsername,int taskId);
}
