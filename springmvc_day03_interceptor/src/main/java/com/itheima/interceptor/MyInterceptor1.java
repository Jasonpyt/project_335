package com.itheima.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public class MyInterceptor1 implements HandlerInterceptor {

    /**
     * 什么时候执行
     *  在控制器方法执行之前执行
     * 作用：在执行控制器方法之前做验证
     * 执行顺序
     *      配置了拦截器链，按照配置的顺序正序执行
     * @param request
     * @param response
     * @param handler
     * @return  如果返回true，则代表放行，postHandle， afterCompletion可以执行
     *          如果返回false，被拦截,postHandle， afterCompletion不会执行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        return true;
    }

    /**
     * 什么时候执行
     *  控制器方法返回值之前执行
     *
     *  执行顺序
     *      配置了拦截器链，按照配置的顺序倒序执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    /**
     * 什么时候执行
     *  页面渲染完成后执行
     * 执行顺序
     *      配置了拦截器链，按照配置的顺序倒序执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
