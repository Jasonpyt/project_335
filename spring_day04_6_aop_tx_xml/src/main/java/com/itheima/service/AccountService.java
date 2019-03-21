package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface AccountService {
    /**
     * 转账
     * @param fromName
     * @param toName
     * @param money
     */
    public void transfer(String fromName, String toName, Double money);

    public List<Account> findAll();
}
