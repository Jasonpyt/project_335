package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public class UserDaoImpl implements UserDao {

    SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public List<User> findAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = sqlSession.selectList("com.itheima.dao.UserDao.findAll");
        sqlSession.close();
        return userList;
    }

    @Override
    public User findById(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("com.itheima.dao.UserDao.findById", id);
        sqlSession.close();
        return user;
    }

    @Override
    public List<User> findByName(String name) {
        return null;
    }


    public void sava(User user) {

    }

    @Override
    public void save(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("com.itheima.dao.UserDao.insert",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void delById(Integer id) {

    }

    @Override
    public void update(User user) {

    }
}
