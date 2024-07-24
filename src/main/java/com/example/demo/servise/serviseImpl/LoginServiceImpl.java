package com.example.demo.servise.serviseImpl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.servise.Login;
import com.example.demo.servise.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auror : lsl
 * @Date: 2024-07-22 09:19
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserMapper userMapper;
    @Override
    public Boolean loginCheck(User login) {
        User dbUser=userMapper.getUserByUserName(login);

        return null;
    }

    @Override
    public int ModifyPassword(User login) {
        return 0;
    }

    @Override
    public int DeleteUser(User login) {
        return 0;
    }
}
