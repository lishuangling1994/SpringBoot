package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

/**
 * @Auror : lsl
 * @Date: 2025-09-11 15:09
 */

@SpringBootTest
@Slf4j
public class SpringBootRedis {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void getRedisConnection(){

        log.info("redisTemplate的值是{}",redisTemplate);
        /*获取String的操作对象*/
        ValueOperations valueOperations = redisTemplate.opsForValue();
        /*获取set的操作对象*/
        SetOperations setOperations = redisTemplate.opsForSet();
        /*获取list类型的操作对象*/
        ListOperations listOperations = redisTemplate.opsForList();
        /*获取hash类型的操作对象*/
        HashOperations hashOperations = redisTemplate.opsForHash();
        /*获取有序zset的操作对象*/
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        log.info("获取的几种对象\n{}\n{}\n{}\n{}\n{}",valueOperations,setOperations,
                listOperations,hashOperations,zSetOperations);

        //valueOperations.set("RedisString","RedisTest");
        //String s=valueOperations.get("RedisString").toString();

        redisTemplate.delete("RedisString");
        log.info("获取的key的value是{}",valueOperations.get("RedisString"));

    }
}
