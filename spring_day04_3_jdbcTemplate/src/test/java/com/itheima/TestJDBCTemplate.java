package com.itheima;

import com.itheima.dao.AccountRowMapper;
import com.itheima.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestJDBCTemplate {
    @Autowired

    private JdbcTemplate jdbcTemplate;
    @Test
    public void TestfindAll() {
        String sql = "SELECT * FROM account ";
        for (Account account : jdbcTemplate.query(sql, new AccountRowMapper())) {
            System.out.println(account.getName());
        }

    }

    @Test
    public void testSava(){
        String sql = "INSERT INTO account  values(null,?,?)";
        Account account = new Account();
        account.setName("ggg");
        account.setMoney(10000.);
        jdbcTemplate.update(sql,account.getName(),account.getMoney());

    }

}
