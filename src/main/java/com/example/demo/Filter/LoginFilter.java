package com.example.demo.Filter;

import com.example.demo.controller.UserLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*登录拦截器*/
@Component
public class LoginFilter implements HandlerInterceptor {
    private static final Logger log= LoggerFactory.getLogger(UserLogin.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("进入登录过虑器了！地址是"+request.getRequestURI());
        log.info("请求方法是"+request.getMethod());


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
