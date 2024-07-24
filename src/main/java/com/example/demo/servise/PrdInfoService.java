package com.example.demo.servise;

import com.example.demo.pojo.PrdInfo;
import java.util.List;

/**
 * @Auror : lsl
 * @Date: 2024-07-22 16:52
 */
public interface PrdInfoService{
    public int AddPrdInfo(PrdInfo prdInfo);
    public PrdInfo getPrdInfoByPrdCode(PrdInfo prdInfo);
    public List<PrdInfo> getAllPrdInfos();
    public int ModifyPrdInfoByPrdCode(PrdInfo prdInfo);
}
