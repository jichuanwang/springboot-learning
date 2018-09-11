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
        Bird b = new SeaGull();
        InvocationHandler handler = new DynamicProxy(b);
        Bird bird1 =(Bird)Proxy.newProxyInstance(Bird.class.getClassLoader(),new Class[]{Bird.class},handler);
        Bird bird2 =(Bird)Proxy.newProxyInstance(Bird.class.getClassLoader(),new Class[]{Bird.class},handler);
        System.out.println(bird1.getClass());
        System.out.println(bird2.getClass());
        bird1.eat();
    }
}
