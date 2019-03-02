package xin.zachary.homework.service;

import xin.zachary.homework.entity.User;

import java.util.List;

public interface UserService extends BaseService<User> {
    List queryByUsername(String username);
}
