package xin.zachary.homework.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xin.zachary.homework.dao.StudentDAO;
import xin.zachary.homework.entity.Student;

import java.util.List;

@Repository("studentDAO")
public class StudentDAOImpl extends BaseDAOImpl<Student> implements StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List queryByUsername(String username) {
        String hql = "select s from Student as s where s.username=?0";
        return sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,username).list();

    }

    @Override
    public List queryByTaskId(int taskId) {
        String hql = "select s.username from Student as s where s.classId in (select c.id from Classes as c where c.teacherUsername in (select t.teacherUsername from Task as t where t.id = ?0))";

        return sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,taskId).list();
    }

    @Override
    public List queryUsernameById(int id) {
        String hql = "select s.username from Student as s where s.id = ?0";

        return sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,id).list();
    }
}
