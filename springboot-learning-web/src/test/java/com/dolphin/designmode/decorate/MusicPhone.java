package com.dolphin.designmode.decorate;

/**
 * @author jichuan.wang
 * @since 2018/11/29 13:51
 * <p>
 * </p>
 */
public class MusicPhone extends PhoneDecorate {

    private Iphone iphone;
    public MusicPhone(Iphone iphone){
        super(iphone);
    }

    @Override
    public void call() {
        System.out.println("开始播放音乐了............");
        super.call();
    }
}
