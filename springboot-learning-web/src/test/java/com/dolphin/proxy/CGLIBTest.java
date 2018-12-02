package com.dolphin.proxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author jichuan.wang
 * @<p>:
 * @since 2018/9/11 09:30
 */
public class CGLIBTest implements MethodInterceptor {

    private Object target;
    public Object getInstance(final Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("买房前准备工作...........");
//        Object result = methodProxy.invokeSuper(o,objects);
        Object result2 = method.invoke(target,objects);
        System.out.println("买房后装修工作..........");
        return result2;
    }

    public static void main(String[] args) {
        Bird bird = new SeaGull();
        CGLIBTest cglibTest = new CGLIBTest();
        Bird bird2 = (Bird)cglibTest.getInstance(bird);
        bird2.eat();
        System.out.println(bird2.getClass());
        System.out.println(bird2.getClass().getSuperclass());
        System.out.println(bird2.getClass().getSuperclass().getSuperclass());

        System.out.println(CGLIBTest.class.getName());

    }
}
