package xin.zachary.homework.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xin.zachary.homework.daoimpl.BaseDAOImpl;
import xin.zachary.homework.service.BaseService;




@Service("baseService")
public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private BaseDAOImpl<T> baseDAO;

    @Override
    @Transactional
    public boolean save(T entity) {
        return baseDAO.save(entity);
    }

    @Override
    @Transactional
    public boolean saveOrUpdate(T entity) {
        return baseDAO.saveOrUpdate(entity);
    }

    @Override
    @Transactional
    public boolean delete(T entity) {
        return baseDAO.delete(entity);
    }

    @Override
    @Transactional
    public boolean update(T entity) {
        return baseDAO.update(entity);
    }
}
