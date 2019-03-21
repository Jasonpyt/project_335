package com.itheima;

import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public class TestCRUD {

    @Test
    public void testFindAll(){
        //1. 创建容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = ac.getBean(AccountService.class);
        List<Account> accountList = accountService.findAll();
        for (Account account : accountList) {
            System.out.println(account.getName());
        }
    }


    @Test
    public void testFindById(){
        //1. 创建容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = ac.getBean(AccountService.class);
        Account account = accountService.findById(1);
        System.out.println(account.getName());
    }

    @Test
    public void testSave(){
        //1. 创建容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = ac.getBean(AccountService.class);
        Account account = new Account();
        account.setName("eee");
        account.setMoney(1000.);
        accountService.save(account);
    }
}
