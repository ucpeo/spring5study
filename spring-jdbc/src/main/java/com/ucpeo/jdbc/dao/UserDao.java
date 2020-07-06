package com.ucpeo.jdbc.dao;

import com.ucpeo.jdbc.bean.User;

import java.util.List;

public interface UserDao {
    void insert(User user);
    void delete(Integer id);
    void update(User user);
    User get(Integer id);
    List<User> list();
}

