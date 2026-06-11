package com.self.oop.encapsulation;

public class Text {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("小明");
        s1.setScore(99);
        System.out.println(s1.getScore());
        s1.printPass();

        System.out.println("----------------------------------------");

        Student s2 = new Student();
        s2.setName("小红");
        s1.setScore(-99);
        System.out.println(s2.getScore());
        s2.printPass();
    }
}
