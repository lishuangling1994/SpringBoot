package com.example.demo.servise.serviseImpl;

import com.example.demo.mapper.PrdInfoMapper;
import com.example.demo.pojo.PrdInfo;
import com.example.demo.servise.PrdInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auror : lsl
 * @Date: 2024-07-22 17:18
 *  desc: 产品业务类
 */
@Service
public class PrdInfoImpl implements PrdInfoService {
    private static  final Logger log= LoggerFactory.getLogger(PrdInfoImpl.class);
    @Resource
    private PrdInfoMapper prdInfoMapper;
    @Override
    public int AddPrdInfo(PrdInfo prdInfo) {
        /*新增产品前，查询产品仓库是否已经有此产品，如果有就只改变数据，没有则新增*/
        PrdInfo DbPrdInfo=prdInfoMapper.getPrdInfo(prdInfo);
        if(StringUtils.isEmpty(DbPrdInfo)){
           return prdInfoMapper.AddPrdInfo(prdInfo);
        } else {
            return prdInfoMapper.modifyPrdInfo(prdInfo);
        }
    }

    @Override
    public PrdInfo getPrdInfoByPrdCode(PrdInfo prdInfo) {
        return prdInfoMapper.getPrdInfo(prdInfo);
    }

    @Override
    public List<PrdInfo> getAllPrdInfos() {
        return prdInfoMapper.getAllPrdInfos();
    }

    @Override
    public int ModifyPrdInfoByPrdCode(PrdInfo prdInfo) {
        PrdInfo DbPrdInfo=prdInfoMapper.getPrdInfo(prdInfo);
        if(StringUtils.isEmpty(DbPrdInfo)){
            log.info("系统中，没有这个产品请先新增"+prdInfo.getPrd_prdname());
            return 0;
        }
        return prdInfoMapper.modifyPrdInfo(prdInfo);
    }
}
