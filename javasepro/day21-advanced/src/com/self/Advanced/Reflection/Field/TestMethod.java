package com.self.Advanced.Reflection.Field;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class TestMethod {
    @Test
    public void testFiled1() {
        Class cat = Cat.class;
        Field[] fields = cat.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName() + ":" + field.getType());
        }
    }

    @Test
    public void testFiled2(){
        Class cat = Cat.class;
        try {
            Field fName = cat.getDeclaredField("name");
            Field fAge = cat.getDeclaredField("age");
            System.out.println(fName.getName() + ":" + fName.getType());
            System.out.println(fAge.getName() + ":" + fAge.getType());
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testFiled3(){
        Class cat = Cat.class;
        try {
            Constructor c = cat.getDeclaredConstructor();
            Cat Tom = (Cat)c.newInstance();


            Field fName = cat.getDeclaredField("name");
            fName.setAccessible(true);
            fName.set(Tom,"Tom");


            String name = (String)fName.get(Tom);
            System.out.println(name+":"+Tom);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
