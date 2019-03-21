package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Component("txManager")
@Aspect
public class TransactionManager {

//    配置切入点
    @Pointcut("execution(* com.itheima.service.impl.*.*(..))")
    public void pc(){}

    /**
     * ProceedingJoinPoint: 可以访问真实对象的方法，可以获得返回值
     * @param joinPoint
     */
    @Around("pc()")
    public Object around(ProceedingJoinPoint joinPoint){
        try {
//            开启事务
            beginTransaction();
            //访问真实的对象的方法
            Object result = joinPoint.proceed();
//            提交事务
            commit();
            return result;
        } catch (Throwable throwable) {
//            事务回滚
            rollback();
            throwable.printStackTrace();
        } finally {
//            释放资源
            release();
        }
        return null;
    }

    @Autowired
    private ConnectionUtil connectionUtil;
    //开启事务
    public void beginTransaction(){
        try {
            connectionUtil.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //提交事务
    public void commit(){
        try {
            connectionUtil.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //回滚事务
    public void rollback(){
        try {
            connectionUtil.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void release(){
        try {
            connectionUtil.getThreadConnection().setAutoCommit(true);
            connectionUtil.getThreadConnection().close();
            connectionUtil.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
