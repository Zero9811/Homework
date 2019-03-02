package xin.zachary.homework.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xin.zachary.homework.daoimpl.StudentDAOImpl;
import xin.zachary.homework.entity.Student;
import xin.zachary.homework.service.StudentService;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl extends BaseServiceImpl<Student> implements StudentService {

    @Autowired
    private StudentDAOImpl studentDAO;

    @Override
    @Transactional
    public List queryByUsername(String username) {
        return studentDAO.queryByUsername(username);

    }

    @Override
    @Transactional
    public List queryByTaskId(int taskId) {
        return studentDAO.queryByTaskId(taskId);
    }

    @Override
    public List queryUsernameById(int id) {
        return studentDAO.queryUsernameById(id);
    }
}
