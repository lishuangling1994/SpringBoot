package com.example.demo.controller;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/userLogin")
public class UserLogin {
    private static final Logger log= LoggerFactory.getLogger(UserLogin.class);
    @Resource
    private UserMapper userMapper;
    /*登录检查*/
    @RequestMapping("/loginCheck")
    public ModelAndView loginCheck(User user, HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        /*获取上传的用户名和密码*/
        String username=user.getUsername();
        String password=user.getPassword();
        /*系统中获取*/
        User DbUser=userMapper.getUserByUserName(user);
        log.info("系统中的用户信息"+DbUser);

        if(username.equals(DbUser.getUsername())&&password.equals(DbUser.getPassword())){
            log.info("登陆成功--user--！"+username);
            request.getSession().setAttribute("username",username);
            modelAndView.setViewName("succes");
            modelAndView.addObject("user",DbUser);
            modelAndView.addObject("messge","登录成功");
            return modelAndView;

        }
        else {
            log.info("登录失败！");
            modelAndView.addObject("messge","登录失败！") ;
            modelAndView.setViewName("/succes");
            return modelAndView;

        }
    }
    /*退出登录销毁session*/
    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request){
        request.getSession().invalidate();
        return "已经退出登录了！";
    }
}
