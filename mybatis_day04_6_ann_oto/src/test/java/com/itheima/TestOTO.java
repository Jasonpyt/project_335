package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestOTO {
    @Test
        public void  testUserById(){
            SqlSession sqlSession = new SqlSessionFactoryBuilder().build(this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml")).openSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
           User user = userDao.findById(1);
            System.out.println(user.getUname());
        }

}
