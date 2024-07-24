package com.example.demo.servise;

import com.example.demo.pojo.User;

/**
 * @Auror : lsl
 * @Date: 2024-07-22 09:14
 */
public interface Login {
    public Boolean loginCheck (User login);
    public int ModifyPassword(User login);
    public int DeleteUser(User login);
}
