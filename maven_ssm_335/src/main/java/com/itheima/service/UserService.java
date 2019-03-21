package com.itheima.service;

import com.itheima.domain.User;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface UserService {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public User findById(Integer id);
}
