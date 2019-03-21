package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Controller
@RequestMapping("/product")
@Secured({"ROLE_ADMIN","ROLE_USER"})
public class ProductController {

    @Autowired
    ProductService productService;


    /**
     * 查询全部-- 分页助手
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(
            @RequestParam(name="pageNum",required = false,defaultValue = "1") Integer pageNum ,
            @RequestParam(name="pageSize",required = false,defaultValue = "3") Integer pageSize){
        //根据分页参数查询数据，返回PageBean对象
        PageInfo<Product> pageInfo = productService.findByPageHelper(pageNum, pageSize);
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //添加数据到模型中
        modelAndView.addObject("pageInfo",pageInfo);
        //设置视图名称
        modelAndView.setViewName("product-list");
        //返回ModelAndView对象
        return  modelAndView;
    }
    /**
     * 查询全部-- 手动分页
     * @return
     */
    @RequestMapping("/findAll_2")
    public ModelAndView findAll_2(
            @RequestParam(name="pageNum",required = false,defaultValue = "1") Integer pageNum ,
            @RequestParam(name="pageSize",required = false,defaultValue = "3") Integer pageSize){
        //根据分页参数查询数据，返回PageBean对象
        PageBean<Product> pageBean = productService.findByPage(pageNum, pageSize);
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //添加数据到模型中
        modelAndView.addObject("pageBean",pageBean);
        //设置视图名称
        modelAndView.setViewName("product-list");
        //返回ModelAndView对象
        return  modelAndView;
    }

    /**
     * 查询全部 -- 没有做分页
     * @return
     */
    @RequestMapping("/findAll_1")
    public ModelAndView findAll_1(){
        //查询数据
        List<Product> productList = productService.findAll();
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //添加数据到模型中
        modelAndView.addObject("productList",productList);
        //设置视图名称
        modelAndView.setViewName("product-list");
        //返回ModelAndView对象
        return  modelAndView;
    }

    /**
     * 保存产品
     * @param product
     * @return
     */
    @RequestMapping("/save")
    public String save(Product product){
        //保存
        productService.save(product);
        //请求查询全部
        return "redirect:/product/findAll";
    }

    /**
     * 更新产品数据回显
     * @param id
     * @return
     */
    @RequestMapping("/updateUI")
    public ModelAndView updateUI(Integer id){
        //查询数据
        Product product = productService.findById(id);
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //添加数据到模型中
        modelAndView.addObject("product",product);
        //设置视图名称
        modelAndView.setViewName("product-update");
        //返回ModelAndView对象
        return  modelAndView;
    }

    /**
     * 修改产品
     * @param product
     * @return
     */
    @RequestMapping("/update")
    public String update(Product product){
        //修改操作
        productService.update(product);
        //请求查询全部
        return "redirect:/product/findAll";
    }

    /**
     * 删除单个产品
     * @param id
     * @return
     */
    @RequestMapping("/delOne")
    public String delOne(Integer id){
        //删除操作
        productService.delById(id);
        //请求查询全部
        return "redirect:/product/findAll";
    }

    /**
     * 删除多个
     * @param ids
     * @return
     */
    @RequestMapping("/delMany")
    public String delMany(Integer[] ids){
        //执行删除产品
        productService.delMany(ids);
        //请求查询全部
        return "redirect:/product/findAll";
    }
}
