package com.itheima.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("异常解析");
        CustomException customException = new CustomException("系统出错!!");
        //创建模型与视图对象
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("custom",customException);

        //指定页面
        modelAndView.setViewName("error");

        return modelAndView;
    }
}
