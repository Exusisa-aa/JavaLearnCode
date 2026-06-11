package com.self.oop_pro.ConstructorProblemExample;

public class Text {
    public static void main(String[] args) {
        Teacher t = new Teacher("张三",18,"java");
        System.out.println(t.getName() + t.getAge() + t.getSkill());
    }
}
