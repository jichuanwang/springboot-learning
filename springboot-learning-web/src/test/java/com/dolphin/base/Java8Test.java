package com.dolphin.base;

import org.junit.Test;

import javax.jnlp.IntegrationService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by wangjichuan on 2018/8/19.
 */
public class Java8Test {

    @Test
    public void test(){

        List<Integer> myList = new ArrayList<>();
        myList.add(12);
        myList.add(11223);


        myList.stream().forEach(System.out::println);

        int num = 2;
        Function<Integer,Integer> stringConvert = (from) -> from*num;
        System.out.println(stringConvert.apply(4));

    }
}
