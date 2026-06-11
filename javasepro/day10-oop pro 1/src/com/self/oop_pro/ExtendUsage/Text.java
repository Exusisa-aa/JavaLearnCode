package com.self.oop_pro.ExtendUsage;

public class Text {
    public static void main(String[] args) {
        Teacher t = new Teacher();
        t.setName("小明");
        t.setSkill("java");
        Consultant c = new Consultant();
        c.setName("小红");
        c.setNumbers(10);
        System.out.println(t.getName() + "会" + t.getSkill());
        System.out.println("有" + c.getNumbers() + "人问" + c.getName() + "问题");
    }
}
