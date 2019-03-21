package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.util.List;

public class TestDao {
    @Test
    public void testFindAll(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取动态代理
        UserDao UserDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = UserDao.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();

    }

    @Test
    public void testDelById(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取动态代理
        UserDao UserDao = sqlSession.getMapper(UserDao.class);
        UserDao.delById(2);
        sqlSession.close();
    }


}
