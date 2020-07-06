package com.ucpeo.jdbc.service;

import com.ucpeo.jdbc.bean.User;
import com.ucpeo.jdbc.dao.UserDao;

import java.util.List;

public interface UserService {
    void insert(User user);

    void delete(Integer id);

    void update(User user);

    User get(Integer id);

    List<User> list();
}

