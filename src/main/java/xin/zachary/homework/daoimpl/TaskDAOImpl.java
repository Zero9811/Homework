package xin.zachary.homework.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xin.zachary.homework.dao.TaskDAO;
import xin.zachary.homework.entity.Task;

import java.util.List;

@Repository("taskDAO")
public class TaskDAOImpl extends BaseDAOImpl<Task> implements TaskDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List queryById(int id) {
        return sessionFactory.getCurrentSession().createQuery("select t from Task as t where t.id=?0").setParameter(0,id).list();
    }

    @Override
    public List queryByTeacherUsername(String teacherUsername) {
        String hql = "select t from Task as t where t.teacherUsername=?0";
        return sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,teacherUsername).list();
    }

    @Override
    public List queryByStudentUsername(String studentUsername) {
        String hql = "select t from Task as t where t.teacherUsername in (select c.teacherUsername from Classes as c where c.id in (select s.classId from Student as s where s.username=?0))";
        return sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,studentUsername).list();

    }
}
