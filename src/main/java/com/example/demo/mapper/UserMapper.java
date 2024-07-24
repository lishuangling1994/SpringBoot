package com.example.demo.mapper;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*用于用的是注解扫描没有写dao层，因此每一个字段名称都要对上*/

@Mapper
public interface UserMapper {
    public int addUser(User user);
    public User getUserById(User user);
    public User getUserByUserName(User user);
    public int DeleteUserById(User user);
    public int UpdateUser(User user);

}
