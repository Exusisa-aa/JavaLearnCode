package com.self.oop_pro.StaticBlock;

public class Text {
    public static void main(String[] args) {
        System.out.println("静态代码块的初始化类变量：");
        Student.print1();
        Student.print2();
        Student.print1();
        Student.print2();
        System.out.println(Student.name);

        System.out.println("------------------------------------------------------");

        System.out.println("实例代码块写开发日志：");
        Student s1 = new Student();
        Student s2 = new Student();
        System.out.println(s1);
        System.out.println(s2);
    }
}
