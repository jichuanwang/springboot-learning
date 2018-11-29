package com.dolphin.designmode.decorate;

import org.junit.Test;

import java.io.*;

/**
 * @author jichuan.wang
 * @since 2018/11/29 13:48
 * <p>
 * </p>
 */
public class TestClass {
    public static void main(String[] args) {
        Iphone iphone = new CommonPhone();
        iphone = new MusicPhone(iphone);
        PhoneDecorate phoneDecorate = new InteligencePhone(iphone);
        phoneDecorate.call();
    }

    @Test
    public void ioTest() throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new FileReader("E:\\workspace\\jd-project-source-tree\\springboot-learning\\springboot-learning-web\\src\\main\\resources\\1.txt"));
        String aa = bufferedReader.readLine();

        System.out.println(aa);


    }
}
