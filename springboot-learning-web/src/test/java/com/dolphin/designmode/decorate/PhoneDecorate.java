package com.dolphin.designmode.decorate;

/**
 * @author jichuan.wang
 * @since 2018/11/29 13:49
 * <p>
 * </p>
 */
public class PhoneDecorate implements Iphone{

    private Iphone iphone;

    public PhoneDecorate(Iphone iphone){
        this.iphone = iphone;
    }
    @Override
    public void call() {
        iphone.call();
    }
}
