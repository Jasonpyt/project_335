package com.itheima;

import com.itheima.service.AccountService;
import com.itheima.service.impl.AccountServiceImpl;
import com.itheima.utils.TransactionManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class TestTransfer {

    @Autowired
    TransactionManager transactionManager;

    @Autowired
    AccountServiceImpl accountService;

    @Test
    public void testTransfer(){
        accountService.transfer("aaa","bbb", 1.);
    }

    @Test
    public void cglibProxyTransfer(){
        //创建增强类对象
        Enhancer enhancer = new Enhancer();
        //设置代理对象的父类对象
        enhancer.setSuperclass(accountService.getClass());
        //指定增强的方法
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //对业务层的方法进行事务管理
                Object result = null;
                try {
                    //1. 开启事务
                    transactionManager.beginTransaction();
                    //2. 执行转账业务
                    result = method.invoke(accountService, objects);
                    //3. 提交事务
                    transactionManager.commit();
                } catch (Exception e) {
                    //4. 回滚事务
                    transactionManager.rollback();
                    e.printStackTrace();
                }finally {
                    //5. 释放资源
                    transactionManager.release();
                }

                return result;
            }
        });
        //创建代理对象
        AccountServiceImpl accountServiceImpl = (AccountServiceImpl) enhancer.create();
        accountServiceImpl.transfer("aaa","bbb",200.);
    }

    @Test
    public void jdkProxyTransfer(){

        AccountService accountServiceProxy = (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //对业务层的方法进行事务管理
                Object result = null;
                try {
                    //1. 开启事务
                    transactionManager.beginTransaction();
                    //2. 执行转账业务
                    result = method.invoke(accountService, args);
                    //3. 提交事务
                    transactionManager.commit();
                } catch (Exception e) {
                    //4. 回滚事务
                    transactionManager.rollback();
                    e.printStackTrace();
                }finally {
                    //5. 释放资源
                    transactionManager.release();
                }

                return result;
            }
        });

        accountServiceProxy.transfer("aaa","bbb",100.);
    }
}
