package com.dolphin.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author jichuan.wang
 * @<p>:
 * @since 2018/9/10 17:27
 */
public class DynamicProxy implements InvocationHandler {

/*    private Object subject;

    public DynamicProxy(Object o){
        this.subject = o;
    }*/
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke");
        Object o = method.invoke(proxy,args);
        System.out.println("after invoke");
        return o;
    }
}
