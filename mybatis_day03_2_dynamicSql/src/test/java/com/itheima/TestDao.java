package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestDao {
    @Test
    public void testFindByParam(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSession sqlSession = sqlSessionFactoryBuilder.build(this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml")).openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setName("张");
        user.setSex("男");

        List<User> userList = userDao.findByParam(user);
        for (User user1 : userList) {

            System.out.println(user1);
        }
        sqlSession.close();
    }

    @Test
    public void testDelByIdsArray(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSession sqlSession = sqlSessionFactoryBuilder.build(this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml")).openSession(true);
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        Integer[] ids = new Integer[]{1,3,5};
        userDao.delByIds(ids);
        sqlSession.close();
    }

    @Test
    public void testdelByIdsList(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSession sqlSession = sqlSessionFactoryBuilder.build(this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml")).openSession(true);
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<Integer> list = new ArrayList();
        list.add(7);
        list.add(8);
        userDao.delByIdsList(list);
        sqlSession.close();
    }
}
