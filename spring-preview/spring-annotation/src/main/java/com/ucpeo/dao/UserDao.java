package com.ucpeo.dao;



import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    public UserDao(){
        System.out.println("UserService 被创建");
    }

    public  void hello(){
        System.out.println("UserDao--->hello()");
    }

}
