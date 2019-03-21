package com.itheima;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.util.List;

public class testOTO {
    @Test
public void test(){
   SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml"));
    SqlSession sqlSession = sqlSessionFactory.openSession();
    AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
    List<Account> accountList = accountDao.findAll();
    for (Account account : accountList) {

        System.out.println(account.getAccountName());
    }
    sqlSession.close();
}
}
