package xin.zachary.homework.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xin.zachary.homework.daoimpl.TeacherHomeworkDAOImpl;
import xin.zachary.homework.entity.TeacherHomework;
import xin.zachary.homework.service.TeacherHomeworkService;

import java.util.List;

@Service("teacherHomeworkService")
public class TeacherHomeworkServiceImpl extends BaseServiceImpl<TeacherHomework> implements TeacherHomeworkService {

    @Autowired
    private TeacherHomeworkDAOImpl teacherHomeworkDAO;

    @Override
    @Transactional
    public List queryByName(String name) {
        return teacherHomeworkDAO.queryByName(name);
    }
}
