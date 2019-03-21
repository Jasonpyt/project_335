package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.mapper.AccountRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ljr
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public Account findByName(String name) {
        String sql = "select * from account where name = ?";
        return  jdbcTemplate.queryForObject(sql ,new AccountRowMapper(), name);
    }

    public void update(Account account) {
        String sql = "UPDATE account SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql,account.getName(),account.getId());
    }

    public List<Account> findAll() {
        String sql = "SELECT * FROM account ";
        return jdbcTemplate.query(sql,new AccountRowMapper());
    }
}
