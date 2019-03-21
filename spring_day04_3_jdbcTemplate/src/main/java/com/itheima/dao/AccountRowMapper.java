package com.itheima.dao;

import com.itheima.domain.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * 账户对象的映射类
 * 泛型：对应的实体类的名称
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public class AccountRowMapper implements RowMapper<Account> {
    /**
     * 映射一个Account账户
     * @param rs   只是一行的数据
     * @param rowNum  行号-- 不用
     * @return  返回一个账户对象
     * @throws SQLException
     */
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
//        创建账户对象
        Account account = new Account();
//        给账户赋值
        int id = rs.getInt("id");
        account.setId(id);
        account.setName(rs.getString("name"));
        account.setMoney(rs.getDouble("money"));
//        返回账户
        return account;
    }
}
