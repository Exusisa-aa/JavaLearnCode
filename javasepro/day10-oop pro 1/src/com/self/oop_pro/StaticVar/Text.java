package com.self.oop_pro.StaticVar;

public class Text {
    public static void main(String[] args) {
        Student.name = "123";
        Student s1 = new Student();
        System.out.println(s1.name);
        s1.name = "456";
        System.out.println(s1.name);
        Student s2 = new Student();
        System.out.println(s2.name);//name为类变量和实例变量共享，但只有类有name属性
        s1.age = 16;
        //A.age报错，类不能调用实例变量
    }
}
