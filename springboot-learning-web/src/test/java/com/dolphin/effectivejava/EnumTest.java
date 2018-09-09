package com.dolphin.effectivejava;

import org.junit.Test;

/**
 * Created by wangjichuan on 2018/9/7.
 */
public class EnumTest {

    @Test
    public void test(){
        Operation.PLUS.operate();

        System.out.println(Operation.PLUS.ordinal());
        System.out.println(Operation.valueOf("PLUS"));
    }
}
