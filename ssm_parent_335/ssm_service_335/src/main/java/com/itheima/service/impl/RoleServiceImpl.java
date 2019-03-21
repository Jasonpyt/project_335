package com.itheima.service.impl;

import com.itheima.dao.RoleDao;
import com.itheima.domain.Role;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;
    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role findById(Integer roleId) {
        return roleDao.findById(roleId);
    }

    @Override
    public void addPermissionListToRole(Integer roleId, Integer[] ids) {
        //先删除所有的关系
        roleDao.removePermissionListFromRole(roleId);
        //再添加新的关系
        if(ids != null){
            for (Integer permissionId : ids) {
                roleDao.addPermissionToRole(permissionId, roleId);
            }
        }
    }


}
