package xin.zachary.homework.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xin.zachary.homework.daoimpl.GradesDAOImpl;
import xin.zachary.homework.entity.Grades;
import xin.zachary.homework.service.GradesService;

import java.util.List;

@Service("gradesService")
public class GradesServiceImpl extends BaseServiceImpl<Grades> implements GradesService {

    @Autowired
    private GradesDAOImpl gradesDAO;

    @Override
    @Transactional
    public List queryExists(String studentUsername, int taskId) {
        return gradesDAO.queryExists(studentUsername,taskId);
    }

    @Override
    @Transactional
    public List queryByTaskId(int taskId) {
        return gradesDAO.queryByTaskId(taskId);
    }
}
