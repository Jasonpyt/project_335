package com.itheima.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/showUsername")
    public void showUsername(HttpServletRequest request){
        //获取session对象
        HttpSession session = request.getSession();
        //获取session所有的属性名称,返回枚举类型
        //枚举：把所有的情况都列举出来
        Enumeration attributeNames = session.getAttributeNames();
        //遍历枚举类型
        //hasMoreElements : 是否有更多的元素
        //nextElement:获取下一个元素
        //SPRING_SECURITY_CONTEXT:可以根据此名称获取安全框架的上下文对象（域）
//        while(attributeNames.hasMoreElements()){
//            System.out.println(attributeNames.nextElement());
//        }
        Object obj = session.getAttribute("SPRING_SECURITY_CONTEXT");
        //转换为SecurityContext对象
        SecurityContext securityContext = (SecurityContext) obj;
        //获取认证对象: 认证指的的登录信息
        Authentication authentication = securityContext.getAuthentication();
        //获取重要（用户）信息
        Object principal = authentication.getPrincipal();
        User user = (User) principal;
        //获取用户名
        String username = user.getUsername();
        System.out.println(username);
        //从session对象中获取认证信息
//        session.getAttribute("")

//        获取SecurityContext对象 方法二
        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println(securityContext == context);

    }
}
