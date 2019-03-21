package com.itheima;

import com.itheima.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestAnn {
    @Test
    public void test() {
        //1.创建容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //执行方法
        UserDao userDao = (UserDao)ac.getBean("UserDao");
        List list = userDao.findAll();

    }
}
