package com.ucpeo.tx;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class TxHanlder{

    @Pointcut("execution( * com.ucpeo.tx.UserTx.*(..))")
    public void pt() {
    }

    @AfterReturning("pt()")
    public void after(JoinPoint point) {
        System.out.println("UserTx:" + point.getSignature().getName() + "  成功，提交");
    }

    @AfterThrowing("pt()")
    public void throwble(JoinPoint point) {
        System.out.println("UserTx:" + point.getSignature().getName() + "  执行失败,回滚");
    }

    @Before("pt()")
    public  void before(JoinPoint point){
        System.out.println(point.getSignature().getName());
    }
}
