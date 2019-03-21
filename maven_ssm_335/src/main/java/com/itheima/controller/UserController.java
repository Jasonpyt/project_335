package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/findById")
    public ModelAndView findById(Integer id){
//        查询数据
        User user = userService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        //添加数据
        modelAndView.addObject("user",user);
        //指定页面
        modelAndView.setViewName("show");
        return modelAndView;
    }
}
