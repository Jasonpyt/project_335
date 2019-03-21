package com.itheima;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/print")
    public String print(){
        System.out.println("打印");
        return "show";
    }
}
