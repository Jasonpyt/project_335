package com.itheima.controller;

import com.itheima.domain.Permission;
import com.itheima.service.PermissionService;
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
@RequestMapping("/permission")
@Secured({"ROLE_ADMIN"})
public class PermissionController {

    @Autowired
    PermissionService permissionService;
    /**
     * 查询全部
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //查询数据
        List<Permission> permissionList =  permissionService.findAll();
        //添加数据
        modelAndView.addObject("permissionList",permissionList);
        //设置页面
        modelAndView.setViewName("permission-list");
        //返回
        return modelAndView;
    }

    /**
     * 保存数据回显
     * @return
     */
    @RequestMapping("/saveUI")
    public ModelAndView saveUI(){
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //查询父权限数据
        List<Permission> permissionList = permissionService.findParentPermission();
        //添加数据
        modelAndView.addObject("permissionList",permissionList);
        //设置页面
        modelAndView.setViewName("permission-add");
        //返回
        return modelAndView;
    }

    /**
     * 保存权限
     * @param permission
     * @return
     */
    @RequestMapping("/save")
    public String save(Permission permission){
        //保存操作
        permissionService.save(permission);
        //请求查询全部
        return "redirect:/permission/findAll";
    }
}
