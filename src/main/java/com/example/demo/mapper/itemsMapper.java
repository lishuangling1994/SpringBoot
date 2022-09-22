package com.example.demo.mapper;
import com.example.demo.pojo.items;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.*;

@Mapper
public interface itemsMapper {
     public List<items> getItems();
     public items getItemById(@Param("id")int id);
}