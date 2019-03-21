package com.itheima.controller;

import com.itheima.domain.Order;
import com.itheima.domain.Product;
import com.itheima.service.OrderService;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        //查询数据
        List<Order> orderList = orderService.findAll();
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //添加数据到模型中
        modelAndView.addObject("orderList",orderList);
        //设置视图名称
        modelAndView.setViewName("order-list");
        //返回ModelAndView对象
        return  modelAndView;
    }

    /**
     * 保存回显
     * @return
     */
    @RequestMapping("/saveUI")
    public ModelAndView saveUI(){
        //查询数据
        List<Product> productList = productService.findAll();
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //添加数据到模型中
        modelAndView.addObject("productList",productList);
        //设置视图名称
        modelAndView.setViewName("order-add");
        //返回ModelAndView对象
        return  modelAndView;
    }

    /**
     * 保存订单
     * @param order
     * @return
     */
    @RequestMapping("/save")
    public String save(Order order){
        //保存操作
        orderService.save(order);
        //请求查询全部
        return "redirect:/order/findAll";

    }
}
