package com.itheima;

import com.itheima.domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public class TestDI {

    @Test
    public void test(){
        //创建spring 的IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取对象
        User user = ac.getBean("user", User.class);
        System.out.println(user);
    }
}
