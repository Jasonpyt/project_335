package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();


    public List findAll() {
        return null;
    }
}
