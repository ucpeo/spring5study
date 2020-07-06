package com.ucpeo.proxy;


import com.ucpeo.service.IService;
import com.ucpeo.service.Service;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ISproxy {

    @Before("execution( * com.ucpeo.service.*.*(..))")
    public void before(JoinPoint point) {
        if (point.getThis() instanceof IService) //判断代理对象是否为目标类的实现类或子类的实现或接口实现
        {
            if ("hello".equals(point.getSignature().getName())) {
                System.out.println("before :执行了hello 方法");
            } else if ("add".equals(point.getSignature().getName())) {
                System.out.println("before : add ：" + point.getArgs()[0] + "+" + point.getArgs()[1]);
            }
        }
    }

    // 切入点
    @Pointcut("execution( * com.ucpeo.service.*.*(..))")
    public void point() {
    }

    @Around("point()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        if (proceedingJoinPoint.getThis() instanceof IService) //判断代理对象是否为目标类的实现类或子类的实现或接口实现
        {
            if ("hello".equals(proceedingJoinPoint.getSignature().getName())) {
                System.out.println("around 执行了hello 方法  执行结果为："+ result);
                System.out.println("around 拦截返回结果  返回 ： 12346579" );
                return  "123456789";

            } else if ("add".equals(proceedingJoinPoint.getSignature().getName())) {
                System.out.println("around add ：" + proceedingJoinPoint.getArgs()[0] + "+" + proceedingJoinPoint.getArgs()[1] + " 结果为：" + result);
            }
        }
        return result;
    }

}
