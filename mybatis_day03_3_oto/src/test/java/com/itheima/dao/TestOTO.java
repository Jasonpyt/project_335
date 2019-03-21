package com.itheima.dao;

import com.itheima.domain.AccountUser;
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
        List<AccountUser> accountUserList = accountDao.findAll();
        for (AccountUser accountUser : accountUserList) {
            System.out.println(accountUser);
        }
        sqlSession.close();
    }
}
