package com.dolphin.tool;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Base64;

/**
 * @author jichuan.wang
 * @<p>:
 * @since 2018/8/30 13:44
 */
public class MqTool {
    @Test
    public void ttt(){
        System.out.println("7F234570000N9001".substring(2));
    }

    @Test
    public void test() throws Exception{
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(MqTool.class.getClassLoader().getResourceAsStream("1.txt")));
        String lineStr;

        while ((lineStr = reader.readLine()) != null){
            String[] strList = lineStr.split("\t");
            String aa = "{\"statementNo\":\""+strList[0].trim()+"\",\"accountId\":"+strList[1].trim()+"}";

            System.out.println(aa);
        }
    }

    @Test
    public void test01(){
        byte[] aa = Base64.getEncoder().encode("http://www.jd.com".getBytes());
        System.out.println(new String(aa));
    }
}
