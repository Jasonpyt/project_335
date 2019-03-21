package com.itheima;

import com.itheima.factory.BeanFactory;
import org.junit.Test;

public class TestBean {
    @Test
    public void Test(){
        Object userDao2 = BeanFactory.getBean("userDao2");
        System.out.println(userDao2);
    }
}
