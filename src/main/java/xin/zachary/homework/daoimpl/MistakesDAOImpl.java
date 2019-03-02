package xin.zachary.homework.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xin.zachary.homework.dao.MistakesDAO;
import xin.zachary.homework.entity.Mistakes;

import java.util.List;

@Repository("mistakesDAO")
public class MistakesDAOImpl extends BaseDAOImpl<Mistakes> implements MistakesDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List queryByStudentUsername(String username) {
        String hql = "select m from Mistakes as m where m.studentUsername=?0 order by m.taskId desc";
        return sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,username).list();
    }

    @Override
    public List queryOneMistake(String studentUsername, int taskId) {
        String hql = "select m from Mistakes as m where m.studentUsername = ?0 and m.taskId = ?1";

        return sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,studentUsername).setParameter(1,taskId).list();
    }
}
