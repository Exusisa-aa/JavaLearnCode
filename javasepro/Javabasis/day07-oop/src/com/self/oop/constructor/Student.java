package com.self.oop.constructor;

public class Student {
    String name;
    double score;
    public Student() {
        System.out.println("无参数构造器被调用了");
    }
    public Student(String name,double score) {
        System.out.println("有参数构造器被调用了");
        this.name = name;
        this.score = score;
    }
}
