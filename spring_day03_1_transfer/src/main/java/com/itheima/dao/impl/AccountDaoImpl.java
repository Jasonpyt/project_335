package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.utils.ConnectionUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private QueryRunner queryRunner;

    @Autowired
    ConnectionUtil connectionUtil;

    @Override
    public Account findByName(String name) {
        String sql = "select * from account where name = ?";
        try {
            Account account = queryRunner.query(connectionUtil.getThreadConnection(),sql, new BeanHandler<>(Account.class), name);
            return account;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateAccount(Account account) {
        String sql = "update account set money = ? where id = ?";
        try {
            queryRunner.update(connectionUtil.getThreadConnection(),sql ,account.getMoney(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
