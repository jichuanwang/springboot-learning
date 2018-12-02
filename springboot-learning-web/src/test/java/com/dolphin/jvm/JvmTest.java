package com.dolphin.jvm;

import com.dolphin.base.Java8Test;

/**
 * Created by wangjichuan on 2018/11/17.
 */
public class JvmTest {

    public static final int _1MB = 1024*1024;

    public static void main(String[] args) {
        byte[] a = new byte[2*_1MB];
        byte[] b = new byte[2*_1MB];
        byte[] c = new byte[2*_1MB];
        byte[] d = new byte[4*_1MB];
        Java8Test s = new Java8Test();

        System.out.println(111);
    }
}
