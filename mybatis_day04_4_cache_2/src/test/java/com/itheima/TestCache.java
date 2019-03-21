package com.itheima;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public class TestCache{

    /**
     * 如果对象要进行持久化操作，就必须的序列化
     *
     * 什么缓存
     *   把查询到的数据存储到缓存中，下次需要时直接从缓存中获取
     * 二级缓存
     *   SqlSessionFactory范围的(应用范围)
     *   不同sqlSession范围的数据可以在缓存中共享
     * 描述：
     *  第一次执行sql语句，查询得到数据，在关闭sqlSession时，会 查询到的数据存储到二级缓存中,以名称空间为范围存储
     *  当对某名称空间范围进行增删改时，会清空该名称空间下的缓存数据
     */
    @Test
    public void test(){
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml"));
        //获取SqlSession
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        //获取动态代理对象
        AccountDao accountDao = sqlSession1.getMapper(AccountDao.class);
        //执行方法
        List<Account> accountList = accountDao.findAll();
        for (Account account : accountList) {
            System.out.println(account.getAccountName());
        }
        sqlSession1.close();

        //第二次执行
        System.out.println("第二次执行");
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        AccountDao accountDao2 = sqlSession2.getMapper(AccountDao.class);
        List<Account> accountList2 = accountDao2.findAll();
        for (Account account : accountList2) {
            System.out.println(account);
        }
        sqlSession2.close();

        //第二次执行
        System.out.println("第三次执行");
        SqlSession sqlSession3 = sqlSessionFactory.openSession();
        AccountDao accountDao3 = sqlSession3.getMapper(AccountDao.class);
        List<Account> accountList3 = accountDao3.findAll();
        for (Account account : accountList3) {
            System.out.println(account);
        }
        sqlSession3.close();
    }
}
