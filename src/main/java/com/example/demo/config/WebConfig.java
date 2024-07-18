package com.example.demo.config;

import com.example.demo.Filter.LoginFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*这是一个配置类，用于实现mvc的配置*/
@Configuration
public class WebConfig implements WebMvcConfigurer{

    /*拦截器配置*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //将自己的拦截器注册到系统拦截器中
       InterceptorRegistration registration= registry.addInterceptor(new LoginFilter());
       //配置自己的拦截器路径，所有的路径都拦截
       registration.addPathPatterns("/**");
       //配置不拦截的路径,首页和登录请求不拦截,所有的html不拦截
       registration.excludePathPatterns("index.html","/userLogin/*");
    }
}
