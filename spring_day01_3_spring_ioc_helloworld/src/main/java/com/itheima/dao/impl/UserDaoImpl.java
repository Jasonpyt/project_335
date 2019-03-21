package com.itheima.dao.impl;

import com.itheima.dao.UserDao;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public class UserDaoImpl implements UserDao {

    public void init(){
        System.out.println("dao对象的初始化");
    }

    public void destroy(){
        System.out.println("dao 对象的销毁");
    }


    public List findAll() {
        return null;
    }
}
