package com.itheima;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml","classpath:applicationContext-service.xml"})
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
public class TestService {

    @Autowired
    UserService service;

    @Test
    public void test(){
        User user = service.findById(2);
        System.out.println(user.getUsername());
    }
}
