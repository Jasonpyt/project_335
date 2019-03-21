package com.itheima;

import com.itheima.dao.RoleDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.Role;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public class TestMTM {

    @Test
    public void testFindAllUser(){
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml")).openSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void testFindAllRole(){
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml")).openSession();

        RoleDao roleDao = sqlSession.getMapper(RoleDao.class);
        List<Role> roleList = roleDao.findAll();
        for (Role role : roleList) {
            System.out.println(role);
        }
        sqlSession.close();
    }
}
