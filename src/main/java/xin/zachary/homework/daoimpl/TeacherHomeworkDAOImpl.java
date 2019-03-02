package xin.zachary.homework.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xin.zachary.homework.dao.TeacherHomeworkDAO;
import xin.zachary.homework.entity.TeacherHomework;

import java.util.List;

@Repository("teacherHomeworkDAO")
public class TeacherHomeworkDAOImpl extends BaseDAOImpl<TeacherHomework> implements TeacherHomeworkDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List queryByName(String name) {
        String hql = "select h from TeacherHomework as h where h.name=?0";
        return sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,name).list();

    }
}
