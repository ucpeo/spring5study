package com.ucpeo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan("com.ucpeo")
public class Config {
    @Bean( "hello")
    String hello(){
        return  "hello";
    }

    @Bean
    List list(){
        return Arrays.asList("A","B","C","D","E","F");
    }
}
