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
public class InsertTool {

    @Test
    public void test() throws Exception{
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(InsertTool.class.getClassLoader().getResourceAsStream("1.txt")));
        String lineStr;

        while ((lineStr = reader.readLine()) != null){
            String result = lineStr.substring(0,lineStr.indexOf("values(")+7);
            String dbIndex = lineStr.substring(lineStr.indexOf("(")+1,lineStr.indexOf(","));
            result = result + (Integer.parseInt(dbIndex)+18) + lineStr.substring(lineStr.indexOf(","));
            System.out.println(result);
        }
        Thread.currentThread().sleep(100);
    }

    @Test
    public void test01(){
        byte[] aa = Base64.getEncoder().encode("http://www.jd.com".getBytes());
        System.out.println(new String(aa));
    }
}
