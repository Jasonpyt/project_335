package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao ;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    public List<Account> findAll() {
        System.out.println(1/0);
        return accountDao.findAll();
    }


    public Account findById(Integer id) {
        return accountDao.findById(id);
    }


    public void save(Account account) {
        accountDao.save(account);

    }


    public void update(Account account) {
        accountDao.update(account);
    }


    public void delById(Integer id) {
        accountDao.delById(id);
    }


    public List<Account> findByName(String name) {
        return accountDao.findByName(name);
    }
}
