package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Controller
@RequestMapping("/test")
public class LoginController {
    /**
     * 登录方法
     *  1. 从页面获取用户名和密码
     *  2. 在数据库判断用户名和密码是否匹配-- 模拟验证
     *  3. 如果验证成功，跳转到查询所有的账户
     *  4. 如果验证失败，跳转到登录页面
     */
    @RequestMapping("/login")
    public String login(String username, String password, HttpServletRequest request){
        //假设数据库中：用户名：zhangsan  密码：123
        if("zhangsan".equals(username) & "123".equals(password)){
            //认证成功后需要将登录信息存储到session域中
            request.getSession().setAttribute("username",username);
            return "redirect:/account/findAll";
        }else{
            return "redirect:/login.jsp";
        }
    }
}
