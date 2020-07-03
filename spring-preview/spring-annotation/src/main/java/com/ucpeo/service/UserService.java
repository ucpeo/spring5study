package com.ucpeo.service;


import com.ucpeo.dao.UserDao;



public class UserService {

    UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


}
