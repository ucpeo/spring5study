package com.ucpeo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        //来自xml
        System.out.println(context.getBean("str"));

        //来自注解
        System.out.println(context.getBean("msg"));


    }
}
