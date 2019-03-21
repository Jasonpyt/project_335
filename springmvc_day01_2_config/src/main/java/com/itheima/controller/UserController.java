package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @Controller：创建控制器对象
 * @RequestMapping("/user"): 标记在类上： 类的请求路径，窄化路径
 * @RequestMapping("/hello"): 标记在方法上，方法的请求路径，可以映射到方法
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello");
        return "show";
    }

    @RequestMapping("/testParam01")
    public String testParam01(
            @RequestParam(value = "username",required = false,defaultValue = "lisi") String name, Integer id, Double price){
        System.out.println("name:"+name);
        System.out.println("price:"+price);
        System.out.println("id:"+id);

        return "show";
    }

    @RequestMapping("/testParam")
    public String testParam(User user){
        System.out.println(user);
        return "show";
    }

    /**
     * 可以使用servlet中的接口操作springMVC
     */
    @RequestMapping("/testServletApi")
    public void testServletApi(HttpServletRequest request, HttpServletResponse response){
        String birthday = request.getParameter("birthday");
        System.out.println(birthday);
        try {
            request.getRequestDispatcher("/WEB-INF/show.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
