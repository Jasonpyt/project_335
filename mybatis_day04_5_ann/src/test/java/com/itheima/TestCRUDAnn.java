package com.itheima;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.util.List;

public class TestCRUDAnn {
    @Test
    public void findAll(){
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml")).openSession();
        AccountDao accoutDao = sqlSession.getMapper(AccountDao.class);
        List<Account> accountList = accoutDao.findAll();
        for (Account account : accountList) {
            System.out.println(account);
        }
        sqlSession.close();
    }


    @Test
    public void testFindById() {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml"));

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取动态代理对象
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        //执行方法
        Account account = accountDao.findById(1);
        System.out.println(account);
        sqlSession.close();
    }

    @Test
    public void testInsert() {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml"));

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取动态代理对象
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        //执行方法
        Account account = new Account();

        account.setAccountName("678912345");
        account.setUserId(15);
        accountDao.insert(account);
        //打印id的值
        System.out.println(account.getId());
        //执行提交
        sqlSession.commit();

        sqlSession.close();
    }

@Test
public void testUpdate(){
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml"));

    SqlSession sqlSession = sqlSessionFactory.openSession();
    //获取动态代理对象
    AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
    Account account = new Account();
    account.setId(1);
    account.setAccountName("66666666666");
    account.setUserId(1);
    accountDao.update(account);
    sqlSession.commit();
    sqlSession.close();
}
@Test
public void testDelById(){
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml"));

    SqlSession sqlSession = sqlSessionFactory.openSession();
    //获取动态代理对象
    AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
    accountDao.delById(3);
    sqlSession.commit();
    sqlSession.close();
}
@Test
public void testfindByName(){
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml"));

    SqlSession sqlSession = sqlSessionFactory.openSession();
    //获取动态代理对象
    AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
    List<Account> byName = accountDao.findByName("66666666666");
    for (Account account : byName) {
        System.out.println(account.getUserId());
    }
    sqlSession.close();
}
}
