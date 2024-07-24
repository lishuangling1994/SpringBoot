package com.example.demo.servise;

import com.example.demo.pojo.User;

/**
 * @Auror : lsl
 * @Date: 2024-07-22 09:14
 */
public interface LoginService {
    public Boolean loginCheck (User login);
    public int ModifyPassword(User login);
    public int DeleteUser(User login);
    public int AddUser(User login);
}
