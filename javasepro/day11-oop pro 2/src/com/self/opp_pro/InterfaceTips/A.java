package com.self.opp_pro.InterfaceTips;

public interface A {
    void test();

    default void test1(){
        System.out.println("接口重写方法被实现了");
    }
}
