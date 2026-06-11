package com.self.Advanced.Annotation.Example;

import java.lang.reflect.Method;

public class TT {
    public void test1(){
        System.out.println("test1");
    }

    @MyTest
    public void test2(){
        System.out.println("test2");
    }

    @MyTest
    public void test3(){
        System.out.println("test3");
    }

    @MyTest
    public void test4(){
        System.out.println("test4");
    }

    public static void main(String[] args) {
        TT t = new TT();
        Class tt = TT.class;
        Method[] methods = tt.getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            if(method.isAnnotationPresent(MyTest.class)){
                try{
                    method.invoke(t);
                }catch (Exception e){
                    e.getStackTrace();
                }
            }
        }
    }
}
