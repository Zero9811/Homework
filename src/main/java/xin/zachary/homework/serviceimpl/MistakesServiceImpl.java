package xin.zachary.homework.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xin.zachary.homework.daoimpl.MistakesDAOImpl;
import xin.zachary.homework.entity.Mistakes;
import xin.zachary.homework.service.MistakesService;

import java.util.List;

@Service("mistakesService")
public class MistakesServiceImpl extends BaseServiceImpl<Mistakes> implements MistakesService {

    @Autowired
    MistakesDAOImpl mistakesDAO;

    //返回一个学生的所有错题，按照作业日期由近期往往期排序
    @Override
    @Transactional
    public List queryByStudentUsername(String username) {
        return mistakesDAO.queryByStudentUsername(username);
    }

    @Override
    public List queryOneMistake(String studentUsername, int taskId) {
        return mistakesDAO.queryOneMistake(studentUsername,taskId);
    }
}
