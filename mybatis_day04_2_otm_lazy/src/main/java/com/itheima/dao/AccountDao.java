package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface AccountDao {
    /**
     * 根据用户id获取账户集合
     * @param userId
     * @return
     */
    public List<Account> findByUserId(Integer userId);
}
