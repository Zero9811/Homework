package xin.zachary.homework.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xin.zachary.homework.dao.TeacherDAO;
import xin.zachary.homework.entity.Teacher;

import java.util.List;

@Repository("teacherDAO")
    public class TeacherDAOImpl extends BaseDAOImpl<Teacher> implements TeacherDAO {
        @Autowired
        private SessionFactory sessionFactory;
        @Override
        public List queryByUsername(String username) {
            String hql = "select t from Teacher as t where t.username=?0";
            return sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,username).list();
        }
}
