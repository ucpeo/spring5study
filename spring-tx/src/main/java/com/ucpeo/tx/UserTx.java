package com.ucpeo.tx;

import com.ucpeo.jdbc.bean.User;
import com.ucpeo.jdbc.service.UserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional()
public class UserTx {
    @Autowired
    UserService userService;


    /*
     * 假设有如下应用需求。年龄交易。A的年龄可以交易部分给B
     * 若 A 30岁、 B 10岁 则 A交易5岁给B  则 A 25岁 B 15岁
     * 以下代码模拟成功和失败的情况
     * */
    public void pass() {
        User u1 = userService.get(2);
        User u2 = userService.get(6);
        System.out.println(u1);
        System.out.println(u2);
        if (u2.getAge() >= 6) {

            u2.setAge(u2.getAge() - 5);
            u1.setAge(u1.getAge() + 5);

            userService.update(u1);
            userService.update(u2);
        }
        u1 = userService.get(2);
        u2 = userService.get(6);
        System.out.println(u1);
        System.out.println(u2);

    }

    public void fail() {
        User u1 = userService.get(2);
        User u2 = userService.get(6);
        System.out.println(u1);
        System.out.println(u2);
        if (u2.getAge() >= 6) {
            u2.setAge(u2.getAge() - 5);
            userService.update(u2);
            u1.setAge(u1.getAge() + 5);
            userService.update(u1);
            throw new RuntimeException();

        }


    }


}

