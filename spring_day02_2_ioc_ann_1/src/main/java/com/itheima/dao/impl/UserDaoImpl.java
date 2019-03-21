package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @Scope  :指定对象的范围
 * @PostConstruct: 相当于xmlbean标签中的init-method属性
 * @PreDestroy: 相当于xml bean标签中的destroy-method属性
 * @author 黑马程序员
 *
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Repository("userDao")

public class UserDaoImpl implements UserDao {
    @Override
    public List findAll() {
        System.out.println("持久层的findAll方法1");
        return null;
    }
}
