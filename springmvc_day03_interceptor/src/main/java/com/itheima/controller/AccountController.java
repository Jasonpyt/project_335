package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @RequestMapping("/print")
    public String print(){
        System.out.println("打印");
        return "show";
    }
}
