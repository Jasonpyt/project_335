package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.dao.mapper.AccountRowMapper;
import com.itheima.domain.Account;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    @Override
    public List<Account> findAll() {
        String sql = "select * from account";
        return this.getJdbcTemplate().query(sql ,new AccountRowMapper());
    }

    @Override
    public Account findById(Integer id) {
        String sql = "select * from account where id = ?";
        return this.getJdbcTemplate().queryForObject(sql, new AccountRowMapper(),id);
    }

    @Override
    public void save(Account account) {
        String sql = "insert into account values(null, ? ,?)";
        this.getJdbcTemplate().update(sql ,account.getName(),account.getMoney());
    }
}
