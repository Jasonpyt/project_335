package com.itheima.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 记录日志
 *     记录什么时间访问
 *     访问了什么
 * 通知类型
 *      前置增强
 *      后置增强
 *      异常增强
 *      最终增强
 *
 *      环绕增强: 相当于上面的四种增强相加
 *
 * @Aspect: 指定该类为切面类
 * @Component: 创建该类的对象
 * 切面= 切入点 +增强
 *
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Component
@Aspect
public class TestLog {
    /**
     * 配置切入点
     * 方法名称任意，参数任意，返回值类型任意
     */
    @Pointcut("execution(* com.itheima.dao.impl.*.*(..))")
    public void aa(){}

    /**
     * JoinPoint 连接点对象
     * @param joinPoint
     */
//    @Before("aa()")
    public void before(JoinPoint joinPoint){
        //获取被代理的对象
        Object o = joinPoint.getTarget();
        System.out.println(o.getClass());
        //执行的方法对象
        Signature signature = joinPoint.getSignature();
        System.out.println(signature.getName());
        System.out.println("前置增强");
        System.out.println(new Date());
    }
//    @AfterReturning("aa()")
    public void afterReturning(){
        System.out.println("后置增强");
    }
//    @After("aa()")
    public void after(){
        System.out.println("最终增强");
        System.out.println(new Date());
    }
//    @AfterThrowing("aa()")
    public void afterThrowing(){
        System.out.println("异常增强");
    }

    /**
     * 环绕增强必须调用被代理方法,可以获取被代理方法的返回值
     * 参数：连接点对象
     * ProceedingJoinPoint才可以访问被代理的方法
     */
    @Around("aa()")
    public void around(ProceedingJoinPoint joinPoint){
        try {
            System.out.println("前置增强");
            //调用被代理的方法
            joinPoint.proceed();
            System.out.println("后置增强");
        } catch (Throwable throwable) {
            System.out.println("异常增强");
            throwable.printStackTrace();
        } finally {
            System.out.println("最终增强");
        }
    }

}
