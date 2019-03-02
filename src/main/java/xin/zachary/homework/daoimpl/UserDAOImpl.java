package xin.zachary.homework.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xin.zachary.homework.dao.UserDAO;
import xin.zachary.homework.entity.User;

import java.util.List;

@Repository("userDAO")
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List queryByUsername(String username) {

        return getSession().createQuery("select u from User as u where u.username=?0").setParameter(0,username).list();

    }
}
