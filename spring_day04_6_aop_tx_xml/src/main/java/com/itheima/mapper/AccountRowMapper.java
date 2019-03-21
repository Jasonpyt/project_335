package com.itheima.mapper;

import com.itheima.domain.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Administrator
 */
public class AccountRowMapper implements RowMapper<Account> {
    /**
     * 映射一个Account账户
     * @param rs   只是一行的数据
     * @param rowNum  行号-- 不用
     * @return  返回一个账户对象
     * @throws SQLException
     */
    public Account mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        //创建账户对象
        Account account = new Account();
        //给账户赋值
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        double money = resultSet.getDouble("money");

        //给account对象赋值
        account.setId(id);
        account.setMoney(money);
        account.setName(name);
        //返会账户信息
        return account;
    }
}
