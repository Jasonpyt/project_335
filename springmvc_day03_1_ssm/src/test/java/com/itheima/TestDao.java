package com.itheima;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public class TestDao {

    @Test
    public void testMybatisWithSpring(){
        //创建容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取对象
        AccountDao accountDao = ac.getBean(AccountDao.class);

        //执行操作
        List<Account> accountList = accountDao.findAll();
        for (Account account : accountList) {
            System.out.println(account.getName());
        }

    }

    @Test
    public void testMybatisFindAll(){
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml"));

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取动态代理对象
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        //执行操作
        List<Account> accountList = accountDao.findAll();
        for (Account account : accountList) {
            System.out.println(account.getName());
        }
        sqlSession.close();
    }
}
