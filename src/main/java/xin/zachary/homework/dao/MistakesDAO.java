package xin.zachary.homework.dao;

import xin.zachary.homework.entity.Mistakes;

import java.util.List;

public interface MistakesDAO extends BaseDAO<Mistakes> {
    List queryByStudentUsername(String username);
    List queryOneMistake(String studentUsername,int taskId);
}
