package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

/**
 * @author ljr
 */
public interface AccountDao {
    /**
     * 根据名字查询账户信息
     * @param forName
     * @return
     */
    Account findByName(String forName);

    /**
     * 更新账户信息
     * @param account
     */
    void update(Account account);


    /**
     * 查询所有账户信息
     *
     * @return
     */
    List<Account> findAll();
}
