package com.itheima.service;

import com.itheima.domain.Role;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface RoleService {
    /**
     * 查询全部
     * @return
     */
    List<Role> findAll();

    /**
     * 保存角色
     * @param role
     */
    void save(Role role);


    Role findById(Integer roleId);
    /**
     * 添加权限
     * @param roleId
     * @param ids
     */
    void addPermissionListToRole(Integer roleId, Integer[] ids);
}
