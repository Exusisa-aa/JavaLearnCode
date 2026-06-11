package com.self.oop.constructor;

public class Text {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("小明",100);
        System.out.println(s2.name);
        System.out.println(s2.score);
    }
}
