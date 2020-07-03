package com.ucpeo;

import com.ucpeo.config.Config;
import com.ucpeo.dao.OrderDao;
import com.ucpeo.dao.UserDao;
import com.ucpeo.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);


        OrderDao orderDao = context.getBean(OrderDao.class);

        orderDao.hello();

        UserService userService = context.getBean(UserService.class);

        userService.getUserDao().hello();

        System.out.println(userService==context.getBean(UserService.class));


    }
}
