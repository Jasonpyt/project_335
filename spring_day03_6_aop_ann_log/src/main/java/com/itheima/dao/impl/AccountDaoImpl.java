package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Repository
public class AccountDaoImpl implements AccountDao {




    public List<Account> findAll() {
        System.out.println("查询全部");
        return null;
    }


    public Account findById(Integer id) {
        System.out.println("根据id查询");
        return null;
    }


    public void save(Account account) {
        System.out.println("保存账户");
    }


    public void update(Account account) {
        System.out.println("更新账户");
    }


    public void delById(Integer id) {
        System.out.println("删除账户");
    }


    public List<Account> findByName(String name) {
        System.out.println("模糊查询");
        return null;
    }
}
