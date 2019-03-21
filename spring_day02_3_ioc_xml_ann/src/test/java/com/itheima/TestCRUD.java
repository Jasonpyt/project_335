package com.itheima;

import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestCRUD {
    @Autowired
    AccountService accountService;
    @Test
    public void testfindAll(){
        //1.创建容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        AccountService accountList = ac.getBean(AccountService.class);
        List<Account> all = accountService.findAll();
        for (Account account : all) {
            System.out.println(account.getName());
        }



    }
}
