package com.dolphin.algorithm;

import java.util.Arrays;

/**
 * @author jichuan.wang
 * @<p>:
 * @since 2018/9/4 18:09
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] data = new int[]{2,12,1,3,29};
        printList(data);
        sort(data,0,data.length-1);
        printList(data);
    }

    public static void printList(int[] d){
        for(int i=0;i<d.length;i++){
            System.out.print(d[i]+"  ");
        }
        System.out.println();
    }

    public static void sort(int[] data,int left,int right){
        int baseValue = data[left];
        int i= left;
        int j = right;
        if(left < right){
            while (i < j){
                while (i<j && data[j]>=baseValue){
                    j--;
                }
                if(i<j){
                    data[i++] = data[j];
                }

                while (i<j && data[i]<=baseValue){
                    i++;
                }
                if(i<j){
                    data[j--] = data[i];
                }

            }
            data[i] = baseValue;
            sort(data,left,i-1);
            sort(data,i+1,right);
        }
    }
}
