package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;

import javax.annotation.Resource;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Resource(name = "userDaomImp2")
    UserDao userDao;
    @Override
    public List findAll() {
        return userDao.findAll();
    }
}
