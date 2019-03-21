package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testReturnType01")
    public void testReturnType01(){
        System.out.println("执行了");
    }

    /**
     * 返回值为String类型
     *  进入视图解析器，进行地址拼接
     *
     * @return
     */
    @RequestMapping("/testReturnType")
    public String testReturnType02(){
        //默认：转发跳转， forward
        // redirect：重定向
            // 1 不会进入视图解析器
            //2. 可以请求另一个路径
        return "redirect:/user/testReturnType01";
    }

    /**
     * 返回值为ModelAndView
     *      Model:模型数据
     *      View:视图
     * @return
     */
    @RequestMapping("/testReturnType03")
    public ModelAndView testReturnType03(){
        //1.  创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //从数据库查询得到数据
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("zhangsan");
        user1.setAge(20);
        User user2 = new User();
        user2.setId(2);
        user2.setUsername("wangwu");
        user2.setAge(21);
        userList.add(user1);
        userList.add(user2);
        //2. 添加数据
        /**
         * 参数1： 属性名
         * 参数2：属性值
         */
        modelAndView.addObject("userList", userList);
        //3. 指定跳转页面
        /***
         * 该字符串会进入视图解析器拼接字符串
         */
        modelAndView.setViewName("show");
        //5. 返回ModelAndView对象
        return modelAndView;
    }
}
