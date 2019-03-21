package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testJson")
    @ResponseBody



    /**
     * @ResponseBody: 标记了@ResponseBody的方法返回值以流的形式返回页面
     *   response.getWriter().write(userList);
     * @param username
     * @return
     */
    public List<User> testJson(@RequestBody String username){
        List<User>userList = new ArrayList<>();
        User user1 = new User();
        user1.setId(1);
        user1.setAge(10);
        user1.setUsername("zhangsan");
        User user2 = new User();
        user2.setId(2);
        user2.setUsername("lisi");
        user2.setAge(20);
        userList.add(user1);
        userList.add(user2);
        return userList;
    }
}
