package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.example.demo.pojo.li;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface liMapper {
    public List<li> getLi();
    public li getLiById(@Param("id") int id);
    public int insertLi( li li);
    public int updateLiById(@Param("id")int id,@Param("age") int age);
    public int deleteLiById(@Param("id") int id);
    public int insertLi1(li li);
    public int UpdateLiAllByid(li li);
}
