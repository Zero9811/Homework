package xin.zachary.homework.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xin.zachary.homework.daoimpl.ClassesDAOImpl;
import xin.zachary.homework.entity.Classes;
import xin.zachary.homework.service.ClassesService;

import java.util.List;

@Service("classesService")
public class ClassesServiceImpl extends BaseServiceImpl<Classes> implements ClassesService {

    @Autowired
    private ClassesDAOImpl classesDAO;

    @Override
    @Transactional
    public List queryById(int id) {
        return classesDAO.queryById(id);
    }

    @Override
    public List queryAll() {
        return classesDAO.queryAll();
    }
}
