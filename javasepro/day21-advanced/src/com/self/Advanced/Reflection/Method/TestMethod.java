package com.self.Advanced.Reflection.Method;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestMethod {
    @Test
    public void testMethod1() {
        Class cat = Cat.class;
        Method[] methods = cat.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + ":" + method.getParameterCount() + ":" + method.getReturnType());
        }
    }

    @Test
    public void testMethod2() {
        Class cat = Cat.class;
        try {
            Method method1 = cat.getDeclaredMethod("run");
            Method method2 = cat.getDeclaredMethod("eat",String.class);
            System.out.println(method1.getName() + ":" + method1.getParameterCount() + ":" + method1.getReturnType());
            System.out.println(method2.getName() + ":" + method2.getParameterCount() + ":" + method2.getReturnType());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testMethod3() {
        Class cat = Cat.class;
        try {
            Constructor c = cat.getDeclaredConstructor(String.class,int.class,double.class);
            c.setAccessible(true);
            Cat Tom = (Cat)c.newInstance("Tom",3,2);

            Method method = cat.getDeclaredMethod("eat",String.class);
            method.setAccessible(true);
            String eating = (String) method.invoke(Tom,"fish");
            System.out.println(eating);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
