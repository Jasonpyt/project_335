package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.dao.mapper.AccountRowMapper;
import com.itheima.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Account> findAll() {
        String sql = "select * from account";
        return jdbcTemplate.query(sql ,new AccountRowMapper());
    }

    @Override
    public Account findById(Integer id) {
        String sql = "select * from account where id = ?";
        return jdbcTemplate.queryForObject(sql, new AccountRowMapper(),id);
    }

    @Override
    public void save(Account account) {
        String sql = "insert into account values(null, ? ,?)";
        jdbcTemplate.update(sql ,account.getName(),account.getMoney());
    }
}
