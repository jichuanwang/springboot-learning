package com.dolphin.effectivejava;

/**
 * Created by wangjichuan on 2018/9/7.
 */
public enum  Operation {

    PLUS("+"){

        @Override
        void operate() {
            System.out.println(getCode());
        }
    };
    private String code;

    Operation(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    abstract void operate();
}
