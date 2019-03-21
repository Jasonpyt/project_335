package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Repository
public class UserDaoImpl2 implements UserDao {
    @Override
    public List findAll() {
        System.out.println("持久层的findAll方法2");
        return null;
    }
}
