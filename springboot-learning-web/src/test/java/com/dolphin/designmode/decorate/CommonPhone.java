package com.dolphin.designmode.decorate;

/**
 * @author jichuan.wang
 * @since 2018/11/29 13:48
 * <p>
 * </p>
 */
public class CommonPhone implements Iphone {
    @Override
    public void call() {
        System.out.println("开始打电话...........");
    }
}
