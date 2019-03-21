package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Role;
import com.itheima.domain.SysUser;
import com.itheima.service.RoleService;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
@Secured({"ROLE_ADMIN"})
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name="pageNum",required = false,defaultValue = "1") Integer pageNum ,
                                @RequestParam(name="pageSize",required = false,defaultValue = "3") Integer pageSize){
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //查询数据
        PageInfo<SysUser> pageInfo = userService.findByPageHelper(pageNum,pageSize);
        //添加数据到模型视图对象中
        modelAndView.addObject("pageInfo",pageInfo);
        //指的视图名称
        modelAndView.setViewName("user-list");
        //返回ModelAndView对象
        return modelAndView;
    }

    /**
     * 保存用户
     * @param user
     * @return
     */
    @RequestMapping("/save")
    public String save(SysUser user){
        //保存操作
        userService.save(user);
        //重定向：查询全部
        return "redirect:/user/findAll";
    }

    /**
     *
     * @return
     */
    @RequestMapping("/checkName")
    @ResponseBody
    public String checkName(String username){
        //在业务层判断是否存在用户名
        boolean b = userService.checkName(username);
        //把结果返回页面
        //true : 存在该用户名不可用
        //false： 不存在用户名，可用
        return b+"";
    }


    /**
     * 获取某用户的详情功能
     * @param id 某用户的id
     * @return
     */
    @RequestMapping("/details")
    public ModelAndView details(Integer id){
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //查询数据
        SysUser user = userService.findById(id);

        //添加数据到模型视图对象中
        modelAndView.addObject("user",user);
        //指的视图名称
        modelAndView.setViewName("user-show");
        //返回ModelAndView对象
        return modelAndView;
    }

    /**
     * 添加角色到用户的数据回显
     *      需要的数据
     *             所有的角色信息
     *             原来拥有的角色
     *             用户的id
     * @param userId
     * @return
     */
    @Autowired
    RoleService roleService;
    @RequestMapping("/addRoleListToUserUI")
    public ModelAndView addRoleListToUserUI(Integer userId){
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //查询数据
        //查询所有的角色
        List<Role> roleList = roleService.findAll();
        //用户已有的角色
        SysUser user = userService.findById(userId);
        List<Role> userWithRoleList = user.getRoleList();
        //把用户已有的角色id存入一个字符串中: ,4,,5,,6,,7,,123,
        StringBuffer sb = new StringBuffer();
        for (Role role : userWithRoleList) {
            sb.append(",");
            sb.append(role.getId());
            sb.append(",");
        }
        //用户的id
        Integer id = user.getId();

        //添加数据到模型视图对象中
        modelAndView.addObject("roleList",roleList);
        modelAndView.addObject("userWithRoleListStr",sb.toString());
        modelAndView.addObject("userId",id);

        //指的视图名称
        modelAndView.setViewName("user-role-add");
        //返回ModelAndView对象
        return modelAndView;
    }

    /**
     * 添加角色到用户
     * @param ids
     * @param userId
     * @return
     */
    @RequestMapping("/addRoleListToUser")
    public String addRoleListToUser(Integer[] ids ,Integer userId){
        //添加
        userService.addRoleListToUser(ids,userId);
        //请求查询全部
        return "redirect:/user/findAll";
    }
}
