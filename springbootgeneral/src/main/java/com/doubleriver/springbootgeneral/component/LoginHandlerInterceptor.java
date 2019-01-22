package com.doubleriver.springbootgeneral.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author ronye
 * @Created 2018/12/17 - 2:30 AM
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String loginUser = (String) session.getAttribute("loginUser");
        logger.trace("loginUser: " + loginUser);
        if(loginUser==null){
            //未登录，返回的登录页面
            request.setAttribute("msg","没有权限查看");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else{
            //已登录，放行请求
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
