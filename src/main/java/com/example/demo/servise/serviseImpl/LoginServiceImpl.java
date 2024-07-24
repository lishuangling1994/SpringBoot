package com.example.demo.servise.serviseImpl;

import com.example.demo.Tool.MD5Utis;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.servise.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * @Auror : lsl
 * @Date: 2024-07-22 09:19
 */
@Service
public class LoginServiceImpl implements LoginService {

    public static final Logger log= LoggerFactory.getLogger(UserMapper.class);

    @Resource
    private UserMapper userMapper;
    @Override
    public Boolean loginCheck(User login) {
        User dbUser=userMapper.getUserByUserName(login);
        String username=login.getUsername();
        String password=login.getPassword();
        if(username.equals(dbUser.getUsername())&&password.equals(dbUser.getPassword())) {
            log.info("登陆成功--user--！" + username);
            return true;
        }
        return  false;
    }

    @Override
    public int ModifyPassword(User login) {
        String password=login.getPassword();
        String md5After=MD5Utis.Md5(password);
        log.info("加密前"+password+"加密后"+md5After);
        login.setPassword(md5After);
        login.setStatus("0");
        return userMapper.UpdateUser(login);
    }

    @Override
    public int DeleteUser(User login) {
        return userMapper.DeleteUserById(login);
    }

    @Override
    public int AddUser(User login) {
        String password=login.getPassword();
        String md5After=MD5Utis.Md5(password);
        log.info("加密前"+password+"加密后"+md5After);
        login.setPassword(md5After);
        return userMapper.addUser(login);
    }
}
