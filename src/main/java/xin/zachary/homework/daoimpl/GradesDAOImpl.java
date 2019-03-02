package xin.zachary.homework.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xin.zachary.homework.dao.GradesDAO;
import xin.zachary.homework.entity.Grades;

import java.util.List;

@Repository("gradesDAO")
public class GradesDAOImpl extends BaseDAOImpl<Grades> implements GradesDAO {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List queryExists(String studentUsername, int taskId) {
        String hql = "select g from Grades as g where g.studentUsername = ?0 and g.taskId = ?1";
        return sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,studentUsername).setParameter(1,taskId).list();
    }

    @Override
    public List queryByTaskId(int taskId) {
        String hql = "select g from Grades as g where g.taskId = ?0";
        return sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,taskId).list();
    }
}
