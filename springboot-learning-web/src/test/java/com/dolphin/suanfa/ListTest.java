package com.dolphin.suanfa;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangjichuan on 2018/8/21.
 */
public class ListTest {

    @Test
    public void test(){

        List<Integer> arrayList = new ArrayList<>();
        testList(arrayList,1000);
//
//        List<Integer> linkList = new LinkedList<>();
//        testList(linkList,1000);

       /* for(Integer num : arrayList){
            if(num %2 ==0){
                arrayList.remove(num);
            }
        }*/

        Iterator<Integer> nums = arrayList.iterator();
        while (nums.hasNext()){
            Integer num = nums.next();
            if(num%2==0){
                nums.remove();
            }
        }

        System.out.println(this);


    }

    public void testList(List<Integer> list,int n){
        long start = System.currentTimeMillis();
        for(int i=0;i<n;i++){
            list.add(0,i);
        }
        long end = System.currentTimeMillis();
        System.out.println(list.getClass()+" time cost="+(end-start));
    }
}
