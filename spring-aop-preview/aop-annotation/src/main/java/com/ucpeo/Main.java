package com.ucpeo;

import com.ucpeo.config.Config;
import com.ucpeo.service.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Service service = context.getBean(Service.class);
        System.out.println(service.hello());
        System.out.println(service.add(99, 1));


    }
}
