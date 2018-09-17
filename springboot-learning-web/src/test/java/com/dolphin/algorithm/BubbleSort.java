package com.dolphin.algorithm;

/**
 * @author jichuan.wang
 * <p> 冒泡算法简单实现
 * @since 2018/9/17 15:17
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] data = {1,54,2,5,211,33};
        printArray(data);
        System.out.println("");
        for(int i=0;i<data.length-1;i++){
            for(int j=0;j<data.length-i-1;j++){
                if(data[j] > data[j+1]){
                    int temp = data[j+1];
                    data[j+1] = data[j];
                    data[j] = temp;
                }
            }
        }
        printArray(data);
    }

    public static void printArray(int[] data){
        for(int i=0;i<data.length;i++){
            System.out.printf(data[i]+" ");
        }
    }
}
