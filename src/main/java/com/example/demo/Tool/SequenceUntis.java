package com.example.demo.Tool;


import java.util.Random;

/**
 * @Auror : lsl
 * @Date: 2024-07-23 16:45
 * desc : 获取流水号
 */
public class SequenceUntis {
    public final static String getSeqSeqNo(){
        long times=System.currentTimeMillis();
        Random random=new Random();
        int r=random.nextInt(1000);
        return String.format("%d%05d",times,r);
    }
}
