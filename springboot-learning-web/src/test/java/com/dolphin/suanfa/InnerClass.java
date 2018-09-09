package com.dolphin.suanfa;

/**
 * Created by wangjichuan on 2018/8/21.
 */
public class InnerClass {

    private int age =10;

    private static String name = "haha";

    public static void main(String[] args) {
        InnerClass.Inner inner = new InnerClass.Inner();
        System.out.println(inner.innerName);
    }



    static class Inner{
//        private int innerAge = age+10;
        public String innerName = name;
    }
}
