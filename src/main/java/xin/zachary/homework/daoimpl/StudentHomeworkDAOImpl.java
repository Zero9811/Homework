package xin.zachary.homework.daoimpl;

import org.springframework.stereotype.Repository;
import xin.zachary.homework.dao.StudentHomeworkDAO;
import xin.zachary.homework.entity.StudentHomework;

@Repository("studentHomeworkDAO")
public class StudentHomeworkDAOImpl extends BaseDAOImpl<StudentHomework> implements StudentHomeworkDAO {
}
