package com.ucpeo.service;

@org.springframework.stereotype.Service
public class IService  implements  Service{

    public String hello(){
     return  "hello";
   }

    public Integer add(Integer a, Integer b) {
        return a+b;
    }

}
