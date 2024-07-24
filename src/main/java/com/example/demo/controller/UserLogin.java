package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.servise.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private LoginService loginService;
    /*登录检查*/
    @RequestMapping("/loginCheck")
    public ModelAndView loginCheck(User user, HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        /*获取上传的用户名和密码*/
        String username=user.getUsername();
        if(!username.isEmpty()&&loginService.loginCheck(user)){
            request.getSession().setAttribute("username",username);
            modelAndView.setViewName("redirect:/succes.html");
            modelAndView.addObject("messge","登录成功");
            return modelAndView;

        }
        else {
            log.info("登录失败！");
            modelAndView.addObject("messge","登录失败，请重新登录！") ;
            modelAndView.setViewName("/index");
            return modelAndView;

        }
    }
    /*退出登录销毁session*/
    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request){
        request.getSession().invalidate();
        return "已经退出登录了！";
    }
    @RequestMapping("/updatePassword")
    public String updatePassword(User user){
        loginService.ModifyPassword(user);
        return "更新成功";
    }

    @RequestMapping("/registUser")
    public String registUser(User login){
        loginService.AddUser(login);
        return  "注册成功";
    }
}
