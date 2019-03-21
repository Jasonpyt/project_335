package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    @Override
    public List<Account> findAll() {
        String sql = "select * from account";
        try {
            List<Account> accountList = queryRunner.query(sql, new BeanListHandler<>(Account.class));
            return accountList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Account findById(Integer id) {
        String sql = "select * from account where id = ?";
        try {
            Account account = queryRunner.query(sql, new BeanHandler<>(Account.class),id);
            return account;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Account account) {
        String sql = "insert into account values(null, ?,?)";
        try {
            queryRunner.update(sql ,account.getName() ,account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Account account) {
        String sql = "update account set name = ? , money = ? where id = ?";
        try {
            queryRunner.update(sql , account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delById(Integer id) {
        String sql = "delete from account where id = ?";
        try {
            queryRunner.update(sql , id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Account> findByName(String name) {
        String sql = "select * from account where name like '%'?'%'";
        try {
            List<Account> accountList = queryRunner.query(sql, new BeanListHandler<>(Account.class), name);
            return accountList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
