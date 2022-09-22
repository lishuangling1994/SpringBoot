package com.example.demo;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class JedisDemo {
    @Test
  public void getConnection(){
        //创建redis的连接 jdedis的构造方法有多个参数类型的使用加ip和端口的类型
       Jedis jedis=new Jedis("127.0.0.1",6379);
      /* 设置redis的密码由于本机没有设置密码因此省略
       *jedis.auth("");*/
       System.out.println("连接成功");
       //redis选择数据库
       jedis.select(0);
       String name=jedis.get("name");
        System.out.println(name);
        jedis.close();
    }
}
