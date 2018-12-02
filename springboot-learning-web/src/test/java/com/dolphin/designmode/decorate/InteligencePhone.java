package com.dolphin.designmode.decorate;

/**
 * @author jichuan.wang
 * @since 2018/11/29 13:51
 * <p>
 * </p>
 */
public class InteligencePhone extends PhoneDecorate {

    private Iphone iphone;
    public InteligencePhone(Iphone iphone){
        super(iphone);
    }

    @Override
    public void call() {
        System.out.println("我是智能手机............");
        super.call();
    }
}
