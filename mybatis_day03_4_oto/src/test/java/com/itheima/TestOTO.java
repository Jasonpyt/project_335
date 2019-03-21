package com.itheima;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public class TestOTO {

    @Test
    public void test(){
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml")).openSession();

        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        List<Account> accountList = accountDao.findAll();
        for (Account account : accountList) {
            System.out.println(account);
        }
        sqlSession.close();
    }
}
