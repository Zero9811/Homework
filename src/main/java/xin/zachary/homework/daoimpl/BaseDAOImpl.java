package xin.zachary.homework.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xin.zachary.homework.dao.BaseDAO;

@Repository("baseDAO")
public class BaseDAOImpl<T> implements BaseDAO<T> {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public boolean save(T entity) {
        boolean result = false;
        try{
            getSession().save(entity) ;
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean saveOrUpdate(T entity) {
        boolean result = false;
        try{
            getSession().saveOrUpdate(entity);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(T entity) {
        boolean result = false;
        try{
            getSession().delete(entity);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(T entity) {
        boolean result = false;
        try{
            getSession().update(entity);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
