package com.example.demo.Tool;

import java.security.MessageDigest;

/**
 * @Auror : lsl
 * @Date: 2024-07-22 10:31
 */
public class MD5Utis {
    public final static String Md5(String str){
        char chars[]={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        byte strTemp[]= str.getBytes();
        try {
            MessageDigest messageDigest=MessageDigest.getInstance("MD5");
            messageDigest.update(strTemp);
            byte md[]=messageDigest.digest();
            int j=md.length;
            char newstr[]=new char[j*2];
            int k=0;
            for (int i=0;i<j;i++) {
                byte byte0=md[i];
                newstr[k++]=chars[byte0>>>4&0xf];
                newstr[k++]=chars[byte0&0xf];
            }
            return newstr.toString();
        }catch (Exception e){
             return null;
        }



    }

}
