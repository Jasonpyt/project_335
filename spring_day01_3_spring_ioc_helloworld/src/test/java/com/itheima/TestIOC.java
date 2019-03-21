package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class TestIOC {
    @Test
    public void Test() {
        //1.创建spring的IOC容器
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        //2.从容器中获取对象
        Object userDao = ac.getBean("userDao1");
        System.out.println(userDao);

        UserService bean = ac.getBean(UserService.class);
        System.out.println(bean);

        UserDao userDao2 = ac.getBean("userDao2", UserDao.class);
        System.out.println(userDao2);

        Object userDao11 = ac.getBean("userDao1");
        System.out.println(userDao11);




        //获取Resource资源
        ClassPathResource classPathResource = new ClassPathResource("beans.xml");
        //创建beanFactory对象
        BeanFactory beanFactory = new XmlBeanFactory(classPathResource);
        Object userDao1 = beanFactory.getBean("userDao1");
        System.out.println(beanFactory);
        System.out.println(userDao1);


        Object instanceBeanUserDao = ac.getBean("instanceBeanUserDao");
        System.out.println(instanceBeanUserDao);

        //关闭容器
        ac.close();
    }
}
