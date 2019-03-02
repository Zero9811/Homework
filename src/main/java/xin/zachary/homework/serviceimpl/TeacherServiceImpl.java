package xin.zachary.homework.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.zachary.homework.daoimpl.TeacherDAOImpl;
import xin.zachary.homework.entity.Teacher;
import xin.zachary.homework.service.TeacherService;

import java.util.List;

@Service("teacherService")
public class TeacherServiceImpl extends BaseServiceImpl<Teacher> implements TeacherService {
    @Autowired
    private TeacherDAOImpl teacherDAO;
    @Override
    public List queryByUsername(String username) {
        return teacherDAO.queryByUsername(username);
    }
}
