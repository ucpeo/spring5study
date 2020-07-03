package com.ucpeo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        System.out.println(context.getBean("str"));

        System.out.println(context.getBean("user"));

        System.out.println(context.getBean("user1"));

        System.out.println(context.getBean("autowire"));

        System.out.println("\n\n-----------map------------");
        context.getBean("map",Map.class).forEach((k, v) -> System.out.println(k + ":" + v));


        System.out.println("\n\n-----------list------------");
        context.getBean("list",List.class).forEach(System.out::println);
    }


}
