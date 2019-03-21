package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.lang.annotation.Retention;
import java.util.List;

public class TestDaoProxy {
    SqlSessionFactory sqlSessionFactory;
    @Before
    public void init(){
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取接口的动态代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.println(user.getName());
        }
        sqlSession.close();
    }

    @Test
    public void testInsert(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setName("王超");
        user.setAge(35);
        user.setSex("男");
        mapper.save(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void  testFindById(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user= mapper.findById(1);
        System.out.println(user.getName());
        sqlSession.close();
    }
}
