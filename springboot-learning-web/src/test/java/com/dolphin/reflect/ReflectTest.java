package com.dolphin.reflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author jichuan.wang
 * @<p>:
 * @since 2018/8/29 14:19
 */
public class ReflectTest {

    @Test
    public void test1() throws Exception{
        Student student = Student.build("wjc","12121");
        Class clazz = student.getClass();
        Method[] methods = clazz.getMethods();
        for(Method m : methods){
            System.out.println(m.getName());
        }
        Method method = clazz.getMethod("getNumber");
        System.out.println(method.invoke(student));



    }
}
