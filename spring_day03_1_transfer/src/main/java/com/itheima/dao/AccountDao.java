package com.itheima.dao;

import com.itheima.domain.Account;

public interface AccountDao {
    //根据账户名称查找账户
    public Account findByName(String name);

    //更新账户
    public void  updateAccount(Account account);
}
