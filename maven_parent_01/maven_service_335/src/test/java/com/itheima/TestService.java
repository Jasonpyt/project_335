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
//classpath:只读读取本项目类路径下的配置文件
//classpath*: 可以本项目和依赖项目的类路径下的配置文件
    //junit 在测试的时候访问的源码,同样可以访问jar包
    //如果使用maven提供的test命令时，只会在本地仓库找依赖的jar包

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml","classpath:applicationContext-service.xml"})
@ContextConfiguration(locations = {"classpath*:spring/*.xml"})
public class TestService {

    @Autowired
    UserService service;

    @Test
    public void test(){
        User user = service.findById(2);
        System.out.println(user.getUsername());
    }
}
