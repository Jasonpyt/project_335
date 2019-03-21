package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public class TestDao {
    SqlSessionFactory sqlSessionFactory;
    @Before
    public void init(){
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindAll(){
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.println(user.getName());
        }
    }

    @Test
    public void testFindById(){
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);

        User user = userDao.findById(1);
        System.out.println(user);
    }

    @Test
    public void testSave(){
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = new User();
        user.setName("王朝");
        user.setAge(22);
        user.setSex("男");
        userDao.save(user);
    }
}
