package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.mapper.liMapper;
import com.example.demo.pojo.li;

import javax.annotation.Resource;

@RestController
public class Li {
    Logger logger= LoggerFactory.getLogger(Li.class);
    @Resource
    public liMapper liMapper;
    @RequestMapping("/getLi")
    public li getLi(Integer liId){
       li person= liMapper.getLiById(liId);

       logger.info(person.toString());
       return person;
    }
}
