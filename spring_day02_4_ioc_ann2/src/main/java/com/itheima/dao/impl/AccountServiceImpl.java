package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domian.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao ;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    @Override
    public void save(Account account) {
        accountDao.save(account);

    }

    @Override
    public void update(Account account) {
        accountDao.update(account);
    }

    @Override
    public void delById(Integer id) {
        accountDao.delById(id);
    }

    @Override
    public List<Account> findByName(String name) {
        return accountDao.findByName(name);
    }
}
