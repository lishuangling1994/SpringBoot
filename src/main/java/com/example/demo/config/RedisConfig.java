package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Auror : lsl
 * @Date: 2025-09-11 15:34
 */
@Configuration
@Slf4j
public class RedisConfig {

    @Bean
    public RedisTemplate getRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate redisTemplate=new RedisTemplate();
        //将redis工厂设置给redisTemplate
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        /*
        * 给value设置为String的序列器，不让会乱码*/
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        /*
         * 给key设置为String的序列器，不让会乱码*/
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }

}
