package com.itheima.log;

import com.itheima.domain.Log;
import com.itheima.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 *
 * 把日志控制作为一个切面对象，使用注解配置切面
 *  切面： 切入点 + 通知（增强）
        切入点：被拦截的方法的定义， 被拦截的方法就是连接点
        通知：被拦截的方法增强的部分
            通知的类型
                前置增强，后置增强，异常增强，最终增强， 环绕增强(执行原始方法，返回原始方法的返回值)



        @Aspect: 声明该类为切面类
        @Component: 创建类对象

        @Pointcut 切入点配置
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Aspect
@Component
public class LogController {

    @Autowired
    LogService logService;

    @Autowired
    HttpServletRequest request;

    /**
     * 切入点配置
     */
    @Pointcut("execution(* com.itheima.controller.*.*(..))")
    public void pc(){}

    /**
     * 前置增强
     */
    @Before("pc()")
    public void before(JoinPoint joinPoint){
        Log log = new Log();
        //访问者的用户名  private String username;
        //获取上下文对象
        SecurityContext securityContext = SecurityContextHolder.getContext();
        //获取认证对象
        Authentication authentication = securityContext.getAuthentication();
        //获取重要对象，用户详情
        Object o = authentication.getPrincipal();
        User user = (User) o;
        //获取用户名
        String username = user.getUsername();
        log.setUsername(username);

        //访问时间  private Date visitTime;
        log.setVisitTime(new Date());

        //访问者ip地址  private String ip;
        //ip包含在请求对象中
        //获取id地址
        String ip = request.getRemoteAddr();
        log.setIp(ip);

        //访问的方法：类全名称 +  方法名  private String method;
        //访问的方法就是连接点
        //target：代理的目标对象， 代理的类对象
        Object obj = joinPoint.getTarget();
        //获取全类名
        String className = obj.getClass().getName();
        //获取方法对象
        Signature signature = joinPoint.getSignature();
        //获取方法名
        String methodName = signature.getName();
        log.setMethod(className + "." +methodName);


        logService.save(log);


    }
}
