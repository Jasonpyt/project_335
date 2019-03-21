package com.itheima.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

import java.util.Date;

public class TestLog {
    public void before(JoinPoint joinPoint){
        Object target = joinPoint.getTarget();
        System.out.println(target.getClass());

        Signature signature = joinPoint.getSignature();
        System.out.println(signature.getName());
        System.out.println("前置增强");
        System.out.println(new Date());
    }


    public void afterReturning(){
        System.out.println("后置增强");
        System.out.println(new Date());

    }

    public void after(){
        System.out.println("最终增强");

    }

    public void afterThrowing(){
        System.out.println("异常增强");
    }

    public void around(ProceedingJoinPoint joinPoint){
        System.out.println("前置增强");
        try {
            joinPoint.proceed();
            System.out.println("后置增强");

        } catch (Throwable throwable) {
            System.out.println("异常增强");

            throwable.printStackTrace();

        }finally {
            System.out.println("最终增强");
        }

    }
}
