package com.self.oop_pro.SingleInstance.lazy;

public class A {
    private static A a;

    public A(){

    }

    public static A getInstance(){
        if(A.a == null){
            A.a = new A();
        }
        return A.a;
    }
}
