package com.itheima.service;

import com.itheima.domain.Permission;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface PermissionService {

    /**
     * 查询全部
     * @return
     */
    List<Permission> findAll();

    /**
     * 查询父权限
     * @return
     */
    List<Permission> findParentPermission();

    /**
     * 保存操作
     * @param permission
     */
    void save(Permission permission);
}
