package com.itheima.dao;

import com.itheima.domain.Account;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface AccountDao {
    /**
     * 根据账户名查找账户
     * @param name
     * @return
     */
    public Account findByName(String name);

    /**
     * 更新账户
     * @param account
     */
    public void updateAccount(Account account);
}
