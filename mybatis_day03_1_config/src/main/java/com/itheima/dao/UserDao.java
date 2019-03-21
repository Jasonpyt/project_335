package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface UserDao {
    public List<User> findAll();

    public void delById(Integer id);
}
