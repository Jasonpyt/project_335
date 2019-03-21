package com.itheima;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public class TestCustomFrame {

    @Test
    public void test(){
        //得到核心配置文件的输入流对象
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        //SqlSessionFactory构建者对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //构建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //获取SqlSession对象
        SqlSession sqlSession = sessionFactory.openSession();
        //执行sql语句
        List list = sqlSession.selectList("com.itheima.dao.UserDao.findAll");

        System.out.println(list);
        //释放资源
        sqlSession.close();
    }
}
