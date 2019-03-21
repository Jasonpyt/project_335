package com.itheima.controller;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import com.itheima.service.PermissionService;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Controller
@RequestMapping("/role")
@Secured({"ROLE_ADMIN"})
public class RoleController {

    @Autowired
    RoleService roleService;

    /**
     * 查询全部
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //查询数据
        List<Role> roleList =  roleService.findAll();
        //添加数据
        modelAndView.addObject("roleList",roleList);
        //设置页面
        modelAndView.setViewName("role-list");
        //返回
        return modelAndView;
    }

    /**
     * 保存角色
     * @param role
     * @return
     */
    @RequestMapping("/save")
    public String save(Role role){
        //保存操作
        roleService.save(role);
        //请求查询全部
        return "redirect:/role/findAll";
    }

    /**
     * 添加权限到角色数据回显
     * @param roleId
     * @return
     */
    @Autowired
    PermissionService permissionService;
    @RequestMapping("/addPermissionListToRoleUI")
    public ModelAndView addPermissionListToRoleUI(Integer roleId){
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //查询数据
        //查询所有的权限
        List<Permission> permissionList = permissionService.findAll();
        //该角色已有的权限:返回一个角色对象，包含权限信息
        Role role = roleService.findById(roleId);
        //把已有的权限的id存储一个字符串中
        StringBuffer sb = new StringBuffer();
        for (Permission permission : role.getPermissionList()) {
            sb.append(",");
            sb.append(permission.getId());
            sb.append(",");
        }
        //角色id
        Integer id = role.getId();
        //添加数据
        modelAndView.addObject("permissionList",permissionList);
        modelAndView.addObject("str", sb.toString());
        modelAndView.addObject("roleId", id);
        //设置页面
        modelAndView.setViewName("role-permission-add");
        //返回
        return modelAndView;
    }

    /**
     * 添加权限到角色
     * @param roleId
     * @param ids
     * @return
     */
    @RequestMapping("/addPermissionListToRole")
    public String addPermissionListToRole(Integer roleId ,Integer[] ids){
        //添加权限
        roleService.addPermissionListToRole(roleId,ids);
        //请求查询全部
        return "redirect:/role/findAll";
    }
}
