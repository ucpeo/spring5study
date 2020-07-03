package com.ucpeo.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

public class  Proxy{
    public void before(JoinPoint joinPoint){
        System.out.println("before");

        System.out.println("目标类:" + joinPoint.getTarget().getClass());
        System.out.println("目标方法的名称:" + joinPoint.getSignature().getName());
        System.out.println("目标方法的参数:" + joinPoint.getArgs().length+ "个:");
        Arrays.asList(joinPoint.getArgs()).forEach(System.out::println);
        System.out.println("------------------------------");

    }


    public Object afterReturn(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        proceedingJoinPoint.getArgs()[0] = "我给你改了,本来是:"+ proceedingJoinPoint.getArgs()[0];
        return  "这是被拦截的返回值:原始返回值："+ proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
    }



}
