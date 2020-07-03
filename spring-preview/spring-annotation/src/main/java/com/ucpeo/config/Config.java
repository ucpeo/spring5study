package com.ucpeo.config;

import com.ucpeo.dao.OrderDao;
import com.ucpeo.dao.UserDao;
import com.ucpeo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.ucpeo")
public class Config {

    @Autowired
    OrderDao orderDao;

    @Bean(value = "msg")
    public String msg() {
        return "msg: 这是一个消息";
    }


    @Bean
    public UserService userService(@Qualifier("msg") String msg, UserDao dao) {
        System.out.println(msg);
        UserService userService = new UserService();
        userService.setUserDao(dao);
        System.out.println("userService 被创建");
        return userService;
    }


}
