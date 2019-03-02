package xin.zachary.homework.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xin.zachary.homework.dao.ClassesDAO;
import xin.zachary.homework.entity.Classes;

import java.util.List;

@Repository("classesDAO")
public class ClassesDAOImpl extends BaseDAOImpl<Classes> implements ClassesDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List queryById(int id) {
        String hql = "select c from Classes as c where c.id=?0";
        return sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,id).list();

    }

    @Override
    public List queryAll() {
        String hql = "select c from Classes as c order by c.teacherUsername";
        return sessionFactory.getCurrentSession().createQuery(hql).list();
    }
}
