package com.self.opp_pro.Interface_JDK8;

public interface Operator {
    //默认方法 default void 方法名
    default void test1(){
        System.out.println("==默认方法==");
        test2();
    }

    private void test2(){
        System.out.println("==私有方法==");
    }

    static void test3(){
        System.out.println("==类方法==");
    }

}
