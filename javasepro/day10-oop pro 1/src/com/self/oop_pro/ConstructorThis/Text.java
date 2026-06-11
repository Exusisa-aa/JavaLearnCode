package com.self.oop_pro.ConstructorThis;

public class Text {
    public static void main(String[] args) {
        Student s = new Student("小明",18);
        System.out.println(s.getAge() + s.getName() + s.getSchool());
    }
}
