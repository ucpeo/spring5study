package com.ucpeo.jdbc.service;

import com.ucpeo.jdbc.bean.User;
import com.ucpeo.jdbc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    public void insert(User user) {
        userDao.insert(user);
    }

    public void delete(Integer id) {
        userDao.delete(id);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public User get(Integer id) {
        return userDao.get(id);
    }

    public List<User> list() {
        return userDao.list();
    }
}
