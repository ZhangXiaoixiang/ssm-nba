package com.example.nba.config;

import com.example.nba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Map;

/**
 * LoginInterceptor
 * 拦截器配置
 *
 * @author 10905 2019/1/23
 * @version 1.0
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;


    //在请求处理之前进行调用（Controller方法调用之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("session情况:   "+(request.getSession().getAttribute("user")));
        if (null!=request.getSession().getAttribute("user")) {
            System.out.println("登录请求的用户名和密码和数据库验证OK-----");
            System.out.println("有session==>" + request.getSession() + "=====通行"+request.getSession().getAttribute("userName"));
//            放行为true,反之拦截
            return true;
        }
        System.out.println("和数据库数据不一致,请重新登录");
        System.out.println("-----------自定义拦截器------------拦截住了----------");
        PrintWriter printWriter = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        printWriter.write("please login again! session时间过期,请重新登录 http://localhost:8080/page/user/login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
