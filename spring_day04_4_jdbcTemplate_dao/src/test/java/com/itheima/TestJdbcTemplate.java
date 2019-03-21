package com.itheima;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
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
@ContextConfiguration("classpath:applicationContext.xml")
public class TestJdbcTemplate {

    @Autowired
    AccountDao accountDao ;

    @Test
    public void testFindAll(){
        List<Account> accountList = accountDao.findAll();
        for (Account account : accountList) {
            System.out.println(account.getName());
        }
    }

    @Test
    public void testFindById(){
        Account account = accountDao.findById(1);
        System.out.println(account.getName());
    }

    @Test
    public void testSave(){
        Account account = new Account();
        account.setName("fff");
        account.setMoney(2000.);
        accountDao.save(account);
    }
}
