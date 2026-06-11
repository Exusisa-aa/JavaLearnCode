package com.self.oop_pro.SingleInstance.lazy;

public class Text {
    public static void main(String[] args) {
        //懒汉式单例模式
        A a1 = A.getInstance();
        A a2 = A.getInstance();
        System.out.println(a1);
        System.out.println(a2);

    }

}
