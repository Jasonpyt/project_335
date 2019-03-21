package com.itheima;

import com.itheima.config.SpringConfiguration;
import com.itheima.domian.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class TestAnn {
    @Autowired
    AccountService accountService;
    @Test
    public void test(){
//        //1. 使用纯注解 创建容器
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        //2. 获取service对象
//        AccountService accountService = ac.getBean(AccountService.class);
        List<Account> accountList = accountService.findAll();
        for (Account account : accountList) {
            System.out.println(account.getName());
        }
    }
}
