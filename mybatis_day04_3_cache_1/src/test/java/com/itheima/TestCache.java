package com.itheima;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.util.List;

public class TestCache {
    @Test
    public void test(){
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml")).openSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        List<Account> accountList = accountDao.findAll();
        for (Account account : accountList) {
            System.out.println(account.getAccountName());
        }
        System.out.println("第一次执行");
        sqlSession.clearCache();//清除缓存
        System.out.println("第二次执行");
       AccountDao accountDao1Dao = sqlSession.getMapper(AccountDao.class);
        List<Account> accountList2 = accountDao1Dao.findAll();
        for (Account account : accountList2) {
            System.out.println(account);

        }
        sqlSession.close();
    }


}
