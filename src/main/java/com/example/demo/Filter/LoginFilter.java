package com.example.demo.Filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*登录拦截器*/
@Slf4j
@Component
public class LoginFilter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("进入登录过虑器了！");
        /*进入登录首页的拦截放过*/
        String uri=request.getRequestURI();
        if(uri.contains("index")){
            return true;
        }
        /*session中没有用户名的情况下去登录首页*/
        String username=(String)request.getSession().getAttribute("username");
        if(username==null){
            log.info("session中没有户名转去登录页面！");
            response.sendRedirect(request.getContextPath()+"/index.html");
        }else
        {
            return true;
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
