package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * @param id
     * @PathVariable从url中后去id的值
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String findById(@PathVariable("id") Integer id) {
        System.out.println(id);
        return "show";
    }

    //添加数据

    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
    public String sava(@PathVariable("id") Integer id) {
        System.out.println("post" + id);
        return "show";
    }

    //更新

    @RequestMapping(value = "/user/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public String update(@PathVariable("id") Integer id) {

        System.out.println("put"+id);
        return "show";
    }

    //删除
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    //加上 @Responsebody 后返回结果不会被解析为跳转路径，而是直接写入HTTP 响应正文中
    @ResponseBody
    public String delete(@PathVariable("id") Integer id){
        System.out.println("delete"+id);
        return "show";
    }
}
