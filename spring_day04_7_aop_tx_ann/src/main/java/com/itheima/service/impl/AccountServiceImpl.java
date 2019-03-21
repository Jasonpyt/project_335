package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ljr
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDao accountDao;

    /**
     * 进行转账的业务层操作
     * @param fromName
     * @param toName
     * @param money
     */
    @Transactional
    public void transfer(String fromName, String toName, Double money) {
        //1.查询转账人的账户
        Account fromAccount = accountDao.findByName(fromName);

        fromAccount.setMoney(fromAccount.getMoney()-money);

        //必须加事务
        accountDao.update(fromAccount);

        //2.查询收款人写信息
        Account toAccount = accountDao.findByName(toName);

        toAccount.setMoney(toAccount.getMoney()+money);

        //需要加事务
        System.out.println(1/0);
        accountDao.update(toAccount);


    }

    /**
     * 查询全部账户信息
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS, isolation= Isolation.DEFAULT , readOnly = true)
    public List<Account> findAll() {
        return accountDao.findAll();
    }
}
