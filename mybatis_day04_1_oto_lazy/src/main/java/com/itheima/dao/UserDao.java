package com.itheima.dao;

import com.itheima.domain.User;

public interface UserDao {
    //根据用户id查询对应的用户信息
    public User findById(Integer userId);
}
