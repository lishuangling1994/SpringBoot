package com.example.demo.controller;


import com.example.demo.servise.UserLi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.mapper.liMapper;
import com.example.demo.pojo.li;
import javax.annotation.Resource;

@RestController
@RequestMapping("/Li")
public class LiController {
   private static final Logger logger= LoggerFactory.getLogger(LiController.class);
    @Resource
    public UserLi userLi;
    @RequestMapping("/getLiById")
    public li getLi(Integer liId){
       li person= userLi.GetLiById(liId);
       logger.info(person.toString());
       return person;
    }

    @RequestMapping("/updateLiAll")
    public li UpdateLiAll(li person){
        int num=userLi.UpdateLiById(person);
        logger.info("更新了%s条数据！",num);
        return userLi.GetLiById(person.getId());
    }
}
