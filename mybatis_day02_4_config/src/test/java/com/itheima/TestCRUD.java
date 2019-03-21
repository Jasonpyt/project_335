package com.itheima;

import com.itheima.domain.User;
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
public class TestCRUD {

    @Test
    public void testFindAll(){
        //获取核心配置文件的输入流对象
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //通过SqlSessionFactoryBuilder构建工厂对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //获取session对象:框架的入口
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行查询操作
        /**
         * 参数：唯一的标志
         */
        List<User> userList = sqlSession.selectList("com.itheima.dao.UserDao.findAll");
        for (User user : userList) {
            System.out.println(user.getName());
        }
        //释放资源
        sqlSession.close();
    }

    @Test
    public void save(){
        //获取核心配置文件的输入流对象
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //通过SqlSessionFactoryBuilder构建工厂对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //获取session对象:框架的入口
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行保存操作
        User user = new User();
        user.setName("小王");
        user.setAge(20);
        user.setSex("男");
        sqlSession.insert("com.itheima.dao.UserDao.save", user);
        System.out.println("id:" +user.getId());
        //提交
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
    @Test
    public void del(){
        //获取核心配置文件的输入流对象
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //通过SqlSessionFactoryBuilder构建工厂对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //获取session对象:框架的入口
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行删除操作
        sqlSession.delete("com.itheima.dao.UserDao.delById", 5);
        //提交
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
    @Test
    public void update(){
        //获取核心配置文件的输入流对象
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //通过SqlSessionFactoryBuilder构建工厂对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //获取session对象:框架的入口
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行更新操作
        User user = new User();
        user.setName("马六");
        user.setAge(17);
        user.setSex("男");
        user.setId(2);
        sqlSession.update("com.itheima.dao.UserDao.update", user);
        //提交
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }


    @Test
    public void findById(){
        //获取核心配置文件的输入流对象
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //通过SqlSessionFactoryBuilder构建工厂对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //获取session对象:框架的入口
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行根据id查询操作
//        List<User> userList = sqlSession.selectList("com.itheima.dao.UserDao.findById", 2);
//        System.out.println(userList.get(0).getName());
        User user = sqlSession.selectOne("com.itheima.dao.UserDao.findById", 2);
        System.out.println(user.getName());
        //提交
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Test
    public void findByName(){
        //获取核心配置文件的输入流对象
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //通过SqlSessionFactoryBuilder构建工厂对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //获取session对象:框架的入口
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //模糊查询
        List<User> userList = sqlSession.selectList("com.itheima.dao.UserDao.findByName", "张");
        for (User user : userList) {
            System.out.println(user.getName());
        }
        //提交
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
}
