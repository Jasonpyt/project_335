package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Service
public class AccountServiceImpl {
    @Autowired
    AccountDao accountDao;


    public void transfer(String fromName, String toName, Double money) {
        //1. 查询转账人的账户
        Account fromAccount = accountDao.findByName(fromName);
        //2. 查询收款人的账户
        Account toAccount = accountDao.findByName(toName);
        //3. 转账
        fromAccount.setMoney(fromAccount.getMoney() - money);
        toAccount.setMoney(toAccount.getMoney() + money);
        //4. 更新数据库
        accountDao.updateAccount(fromAccount);
        //出现异常
        System.out.println(1/0);
        accountDao.updateAccount(toAccount);
    }
}
