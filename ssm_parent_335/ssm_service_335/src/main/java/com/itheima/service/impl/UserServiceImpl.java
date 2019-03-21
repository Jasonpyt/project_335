package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.UserDao;
import com.itheima.domain.Role;
import com.itheima.domain.SysUser;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    /**
     * 根据用户名加载用户
     * @param username 当前登录时，用户名会传参到方法的参数
     * @return UserDetails对象-- User类型对象
     * @throws UsernameNotFoundException
     */
    /**
     * 根据用户名加载用户
     * @param username 当前登录时，用户名会传参到方法的参数
     * @return UserDetails对象-- User类型对象
     *
     * 添加真正的角色对象(指定的是从数据中查询出来的角色对象)
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据username从数据库获取一个用户对象
        SysUser sysUser = userDao.findByUsername(username);
        if( sysUser != null) {
            //创建一个UserDetails对象，返回
//        参数1：用户名 参数2：密码  参数3：角色对象
            //角色集合对象
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            for (Role role : sysUser.getRoleList()) {
                //创建角色对象
                SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+role.getRoleName());
                //添加到集合中
                authorities.add(grantedAuthority);
            }
            UserDetails userDetails = new User(sysUser.getUsername(), sysUser.getPassword(), authorities);
            return userDetails;
        }
        return  null;
    }

    @Override
    public List<SysUser> findAll() {

        return  userDao.findAll();
    }


    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void save(SysUser user) {
        //对原来的密码进行加密
        String pw = passwordEncoder.encode(user.getPassword());
        user.setPassword(pw);
        userDao.save(user);
    }

    @Override
    public PageInfo<SysUser> findByPageHelper(Integer pageNum, Integer pageSize) {
        //初始化参数
        PageHelper.startPage(pageNum,pageSize);
        //查询全部
        List<SysUser> userList = userDao.findAll();
        //创建PageInfo对象
        PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(userList);
        return pageInfo;
    }

    @Override
    public boolean checkName(String username) {
        SysUser sysUser = userDao.checkName(username);
        if(sysUser == null){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public SysUser findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public void addRoleListToUser(Integer[] ids, Integer userId) {
        //先删除原来所有的关系
        userDao.removeAllRoleFromUser(userId);
        //再维护新的关系
        if(ids != null){
            for (Integer roleId : ids) {
                userDao.addRoleToUser(roleId,userId);
            }
        }

    }
}
