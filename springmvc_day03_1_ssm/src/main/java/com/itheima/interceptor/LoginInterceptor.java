package com.itheima.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 登录判断
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public class LoginInterceptor implements HandlerInterceptor{

    /**
     * 在控制器方法执行前拦截
     *
     *  判断：是否登录了,
     *      登录成功后需要将登录信息存储在session中
     *      如果session中存在登录信息，则通过
     *      如果session中不存在登录信息，跳转登录页面
     *  判断你的请求是否登录请求
     *      如果是登录请求，通过
     *      如果不是登录请求，判断是否登录了
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求路径
        String requestURI = request.getRequestURI();
        if(requestURI.contains("login")){
            return true;
        }else{
            //从session中获取用户名
            Object username = request.getSession().getAttribute("username");
            //如果存在放行，
            if(username != null){
                return true;
            }
            //如果不存在，跳转login.jsp
            else{
                response.sendRedirect("/login.jsp");
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
