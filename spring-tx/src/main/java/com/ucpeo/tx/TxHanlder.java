package com.ucpeo.tx;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TxHanlder{

    @Pointcut("execution(* com.ucpeo.tx.UserTx.*(..))")
    public void pointcut() {
    }

    @AfterReturning("pointcut()")
    public void after(JoinPoint point) {
        System.out.println("UserTx:" + point.getSignature().getName() + "  成功，提交");
    }

    @AfterThrowing("pointcut()")
    public void throwble(JoinPoint point) {
        System.out.println("UserTx:" + point.getSignature().getName() + "  执行失败,回滚");
    }
}
