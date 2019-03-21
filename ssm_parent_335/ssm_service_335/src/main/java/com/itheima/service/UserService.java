package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.SysUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 *
 * 给安全框架提供账号和密码
 *  必须继承一个接口 UserDetailsService
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface UserService extends  UserDetailsService {
    /**
     * 查询全部
     * @return
     */
    List<SysUser> findAll();

    /**
     * 保存用户
     * @param user
     */
    void save(SysUser user);


    PageInfo<SysUser> findByPageHelper(Integer pageNum, Integer pageSize);

    /**
     * 检测用户名是否存在
     * @param username
     * @return
     */
    boolean checkName(String username);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    SysUser findById(Integer id);
    /**
     * 添加角色到用户
     * @param ids
     * @param userId
     */
    void addRoleListToUser(Integer[] ids, Integer userId);
}
