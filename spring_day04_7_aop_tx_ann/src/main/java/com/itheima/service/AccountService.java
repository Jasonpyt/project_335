package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

/**
 * @author ljr
 */
public interface AccountService {
    /**
     * 进行转账操作
     * @param forName
     * @param toName
     * @param money
     */
    public void transfer(String forName, String toName, Double money);

    /**
     * 查询所有账户信息
     * @return
     */
       public List<Account>findAll();
}
