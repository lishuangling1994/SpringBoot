package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.mapper.itemsMapper;
import com.example.demo.pojo.items;

import javax.annotation.Resource;

@SpringBootTest
public class itemsMapperTest {
    @Resource
    private itemsMapper itemsMappers;
    @Test
    public void getItem(){

        System.out.println(itemsMappers.getItems());
    }
    @Test
    public void getItemById(){
        System.out.println(itemsMappers.getItemById(1));

    }
}
