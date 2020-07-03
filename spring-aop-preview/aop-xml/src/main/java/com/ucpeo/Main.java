package com.ucpeo;

import com.ucpeo.service.Uservice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");

        Uservice uservice = context.getBean("uservice",Uservice.class);

        System.out.println(uservice.hello("hello"));
    }
}
