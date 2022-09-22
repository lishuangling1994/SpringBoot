package com.example.demo;



import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.junit.rules.Stopwatch;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.mapper.liMapper;
import com.example.demo.pojo.li;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
public class liMapperTest {
    @Resource
    liMapper liMapper;
//    Logger logger= LoggerFactory.getLogger(liMapperTest.class);
    @Test
    void getLis(){
        liMapper.getLi();
    }
    @Test
    void getLiById(){
        liMapper.getLiById(3);
      /*  logger.info("我是info");*/
        log.info("我是info");
        liMapper.getLiById(3);
    }
    @Test
    void deleteLiByIdTest(){
        liMapper.deleteLiById(5);
    }
    @Test
    void updateLiByid(){
        System.out.println("更新了"+liMapper.updateLiById(4,28)+"条记录!!!!!!!!!!!");
    }
    @Test
    void insertLiTest(){
        li li1=new li();
        li1.setName("李双岭");
        li1.setAge(28);
        System.out.println(liMapper.insertLi(li1));
        System.out.println(li1);
    }
    @Test
    void insertLi1(){
        li li1=new li();
        li1.setName("李双岭1");
        li1.setAge(28);
        System.out.println(liMapper.insertLi1(li1));
        System.out.println(li1);
    }
}
