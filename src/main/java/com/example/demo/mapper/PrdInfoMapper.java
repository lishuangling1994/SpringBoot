package com.example.demo.mapper;

import com.example.demo.pojo.PrdInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auror : lsl
 * @Date: 2024-07-22 15:40
 */
@Mapper
public interface PrdInfoMapper {
    public int AddPrdInfo(PrdInfo prdInfo);
    public PrdInfo getPrdInfo(PrdInfo prdInfo);
    public List<PrdInfo> getAllPrdInfos();
    public int modifyPrdInfo(PrdInfo prdInfo);
}
