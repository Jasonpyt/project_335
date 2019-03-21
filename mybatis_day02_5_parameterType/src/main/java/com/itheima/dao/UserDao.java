package com.itheima.dao;

import com.itheima.domain.QueryVO;
import com.itheima.domain.User;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface UserDao {
    /**
     * 多个参数查询
     * @param name
     * @param startIndex
     * @param pageSize
     * @return
     */
    public List<User> findByManyParam(String name, Integer startIndex, Integer pageSize);

    /**
     * 根据参数查询
     *       根据姓名模糊查询
     *       分页参数查询
     *
     * @return
     */
    public List<User> findByParam(QueryVO queryVO);
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
