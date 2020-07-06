package com.ucpeo.jdbc;


import com.ucpeo.jdbc.bean.User;
import com.ucpeo.jdbc.conf.Config;
import com.ucpeo.jdbc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@ContextConfiguration(classes = Config.class)
@RunWith(SpringRunner.class)
public class Mytest {

    @Autowired
    UserService userService;

    @Test
    public  void userList(){
        userService.list().forEach(System.out::println);
    }

    @Test
    public  void add(){
        User user = new User();
        user.setUsername("tom");
        user.setSex("男");
        user.setAge(99);
        userService.insert(user);
        System.out.println(user);
    }

    @Test
    public void update(){
        User user = userService.get(1);
        System.out.println(user);
        user.setUsername("admin:"+ System.currentTimeMillis());
        System.out.println("AAAAAAAAAAAAAAA 修改前  修改后 VVVVVVVVVVVVVVVVVVV");
        userService.update(user);
        userService.list().forEach(System.out::println);
    }




}
