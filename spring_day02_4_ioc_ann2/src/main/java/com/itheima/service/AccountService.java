package com.itheima.service;


import com.itheima.domian.Account;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface AccountService {
    /**
     * 查询全部
     * @return
     */
    public List<Account> findAll();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Account findById(Integer id);

    /**
     * 保存
     * @param account
     */
    public void save(Account account);

    /**
     * 更新
     * @param account
     */
    public void update(Account account);

    /**
     * 根据id删除
     * @param id
     */
    public void delById(Integer id);

    /**
     * 根据姓名模糊查询
     * @param name
     * @return
     */
    public List<Account> findByName(String name);
}
