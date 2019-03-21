package com.itheima.dao;

import com.itheima.domain.User;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface UserDao {
    /**
     * 根据id获取用户对象
     * @param userId
     * @return
     */
    public User findById(Integer userId);
}
