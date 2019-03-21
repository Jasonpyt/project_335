package com.itheima;

import com.itheima.domain.Account;
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
@ContextConfiguration({"classpath:applicationContext.xml"})
public class TestService {

    @Autowired
    AccountService accountService;

    @Test
    public void testFindAll(){
        List<Account> accountList = accountService.findAll();
        for (Account account : accountList) {
            System.out.println(account.getName());
        }
    }

    @Test
    public void testSave(){
        Account account = new Account();
        account.setName("gggg");
        account.setMoney(3000.);
        accountService.save(account);
    }
}
