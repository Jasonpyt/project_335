package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface UserDao {
    /**
     * 查询全部
     * @return
     */
    public List<User> findAll();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public User findById(Integer id);

    /**
     * 根据姓名模糊查询
     * @param name
     * @return
     */
    public List<User> findByName(String name);
    /**
     * 保存
     */
    public void save(User user);

    /**
     * 根据id删除用户
     * @param id
     */
    public void delById(Integer id);

    /**
     * 更新操作
     * @param user
     */
    public void update(User user);
}
