package com.example.service.user;

import com.example.dao.user.UserDao;
import com.example.domain.user.User;

public class UserServiceImpl implements UserService {

    private final UserDao dao;

    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    public void create(User user) {
        dao.create(user);
    }

    public User read(Integer integer) {
        return null;
    }

    public void update(Integer integer, User user) {

    }

    public void delete(Integer integer) {

    }
}
