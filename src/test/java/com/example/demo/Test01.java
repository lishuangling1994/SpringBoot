package com.example.demo;

import com.example.demo.pojo.Inventory_Records;
import com.example.demo.pojo.PrdInfo;
import com.example.demo.servise.Inventory_RecordService;
import com.example.demo.servise.PrdInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Auror : lsl
 * @Date: 2024-07-23 15:38
 */
@SpringBootTest
public class Test01 {
    @Resource
    PrdInfoService prdInfoService;
    @Resource
    Inventory_RecordService inventory_recordService;
    @org.junit.Test
    public void testDate(){
        Date date=new Date();
        /*DateFormat df=DateFormat.getDateInstance(DateFormat.FULL);
        df=new SimpleDateFormat("YYYY-MM-dd");*/
        SimpleDateFormat sm=new SimpleDateFormat("YYYY-MM-dd");
        String trandate=sm.format(date);
        System.out.println(trandate);

        long times=System.currentTimeMillis();
        Random random=new Random();
        int r=random.nextInt(10000);
        String serseqno=String.format("%10d%05d",times,r);
        System.out.println(r);
        System.out.println(times);
        System.out.println(serseqno);
    }
    @Test
    public  void TestPrdInfo(){
        List<PrdInfo> prdInfos=prdInfoService.getAllPrdInfos();
        for (PrdInfo prdInfo: prdInfos)
        {
            System.out.println(prdInfo);
        }
    }
    @Test
    public void testInvent(){
        Inventory_Records inventory_records=new Inventory_Records();
        inventory_records.setPrd_prdcode("000003");
        inventory_records.setFlag("0");
        inventory_records.setPrd_num(10);
        inventory_records.setBei01("货架");
        inventory_records.setTeller("me");
        inventory_recordService.InsertRecord(inventory_records);
    }
}
