package xin.zachary.homework.dao;

import xin.zachary.homework.entity.User;

import java.util.List;

public interface UserDAO extends BaseDAO<User> {
    List queryByUsername(String username);
}
