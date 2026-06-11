package com.self.oop_pro.SingleInstance.hard;

public class A {
    private static A a = new A();

    private A(){

    }

    public static A getInstance(){
        return A.a;
    }
}
