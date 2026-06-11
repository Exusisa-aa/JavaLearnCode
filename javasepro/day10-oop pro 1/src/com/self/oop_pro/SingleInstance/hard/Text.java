package com.self.oop_pro.SingleInstance.hard;

public class Text {
    public static void main(String[] args) {
        //硬汉式单例模式
        A a1 = A.getInstance();
        A a2 = A.getInstance();
//        A a3 = new A();  不能设计新的对象  但能创造一个对象记住retrun值
        System.out.println(a1);
        System.out.println(a2);
    }
}
