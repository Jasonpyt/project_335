package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Controller
@RequestMapping("/test")
@SessionAttributes(names={"username","age"})
public class TestController {
    //数据存放到session中
    @RequestMapping("/testPut")
    public String testPut(Model model){
        model.addAttribute("username","zhangsan");
        model.addAttribute("age",20);
        return "show";
    }
    //从session获取内容
    @RequestMapping("/testGet")
    public String testGet(ModelMap modelMap){
        Object username = modelMap.get("username");
        System.out.println(username);
        Object age = modelMap.get("age");
        System.out.println(age);
        return "show";
    }
    //把Session中的数据清除
    @RequestMapping("/testClean")
    public String testClean(SessionStatus sessionStatus){
        sessionStatus.setComplete();
        return  "show";
    }


//    @ModelAttribute
    public void testModelAttribute(){
        System.out.println("ModelAttribute执行了");
    }

//    /**
//     * 模拟从数据库中根据 用户名查询一个用户对象
//     * @return
//     */
//    @ModelAttribute
//    public User findByUsername(String username){
//        //去数据库查询
//        User user =new User();
//        user.setAge(25);
//        user.setId(6);
//        user.setUsername("wangwu");
//        System.out.println("ModelAttribute:"+user);
//        return user;
//    }
//
//    @RequestMapping("/update")
//    public String update(User user){
//        System.out.println("update:"+user);
//        return "show";
//    }

    @ModelAttribute
    public void findByUsername(String username, Map<String ,User> map){
        //模拟去数据库查询
        User user =new User();
        user.setAge(25);
        user.setId(6);
        user.setUsername("wangwu");
        System.out.println("ModelAttribute:"+user);
//        把从数据库中查询到的user对象存入到Map集合中
        map.put("abc",user);
    }

    @RequestMapping("/update")
    public String update(@ModelAttribute("abc") User user){
        System.out.println("update:"+user);
        return "show";
    }


    @RequestMapping("/print")
    public String print(){
        System.out.println("打印");
        return "show";
    }
}
