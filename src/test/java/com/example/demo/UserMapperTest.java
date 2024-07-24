package com.example.demo;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;
    @Test
    public void getUser(){
        User user=new User();
        user.setId("2");
        User user1=userMapper.getUserById(user);
        System.out.println(user1);
    }
    @Test
     public void addUser(){
        User user2=new User();
        user2.setUsername("Login");
        user2.setPassword("password");
        user2.setStatus("1");
        System.out.println(userMapper.addUser(user2));
    }

}
