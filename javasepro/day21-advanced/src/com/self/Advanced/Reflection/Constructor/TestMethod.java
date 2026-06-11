package com.self.Advanced.Reflection.Constructor;

import org.junit.Test;

import java.lang.reflect.Constructor;

public class TestMethod {
    @Test
    public void testConstructor1() {
        Class cat = Cat.class;
        Constructor[] constructors = cat.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName() + ":" + constructor.getParameterCount());
        }
    }

    @Test
    public void testConstructor2() throws Exception{
        Class cat = Cat.class;
        Constructor constructor1 = cat.getDeclaredConstructor();
        Constructor constructor2 = cat.getDeclaredConstructor(String.class, int.class,double.class);
        System.out.println(constructor1.getName() + ":" + constructor1.getParameterCount());
        System.out.println(constructor2.getName() + ":" + constructor2.getParameterCount());
    }

    @Test
    public void testConstructor3() throws Exception{
        Class cat = Cat.class;
        Constructor constructor = cat.getDeclaredConstructor(String.class,int.class,double.class);
        constructor.setAccessible(true);//暴力反射  无视访问权限
        Cat Tom = (Cat) constructor.newInstance("Tom",3,2);
        System.out.println(Tom.toString());
    }
}
