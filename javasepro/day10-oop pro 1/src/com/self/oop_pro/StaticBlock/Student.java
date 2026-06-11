package com.self.oop_pro.StaticBlock;

public class Student {
    public static String name;

    public Student() {
        System.out.println("构造器被执行了");
    }


    {
        System.out.println("有人创建了对象：" + this);
    }

    public static void print1(){
        System.out.println(name);
    }
    static {
        System.out.println("静态代码块被执行了");//
        Student.name = "123";
    }

    public static void print2(){
        System.out.println(name);
    }
}
