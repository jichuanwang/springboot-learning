package com.dolphin.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author jichuan.wang
 * @<p>:
 * @since 2018/9/10 17:25
 */
public class ProxyTest {

    public static void main(String[] args) {
        InvocationHandler handler = new DynamicProxy();
        Bird bird1 =(Bird)Proxy.newProxyInstance(handler.getClass().getClassLoader(),Bird.class.getClass().getInterfaces(),handler);
        bird1.eat();
    }
}
