package com.self.oop_pro.Rewrite;

import java.util.ArrayList;

public class Text {
    public static void main(String[] args) {
        A a = new A();
        a.print1();
        a.print2("sb",18);
        System.out.println("--------------------------------");
        Student s = new Student("小明",16);
        System.out.println(s);
        System.out.println(s.toString());
        System.out.println("---------------------------------------");
        ArrayList A = new ArrayList<>();
        A.add("sb");
        System.out.println(A);//ArrayList集合已自行修改toString方法
    }
}
