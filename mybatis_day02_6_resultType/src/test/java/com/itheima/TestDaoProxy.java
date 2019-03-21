package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * 动态代理模式Dao开发
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
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
        //执行多条件查询
//        QueryVO queryVO = new QueryVO();
//        User user = new User();
//        user.setName("张");
//        queryVO.setUser(user);
//        queryVO.setStartIndex(0);
//        queryVO.setPageSize(5);
        List<User> userList = userDao.findByManyParam("张",0,2);
        for (User user1 : userList) {
//            System.out.println(user1.getId());
//            System.out.println(user1.getName());
            System.out.println(user1);
        }
        sqlSession.close();
    }

}
