package xin.zachary.homework.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xin.zachary.homework.daoimpl.UserDAOImpl;
import xin.zachary.homework.entity.User;
import xin.zachary.homework.service.UserService;

import java.util.List;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    UserDAOImpl userDAO;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public List queryByUsername(String username) {
        return userDAO.queryByUsername(username);
    }
}
