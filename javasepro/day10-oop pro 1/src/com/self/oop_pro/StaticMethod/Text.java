package com.self.oop_pro.StaticMethod;

public class Text {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student.print1();
        s1.print1();
        //A.print2();报错，类名不能调用实例方法，只有对象可以
        s1.print2();
    }
}
