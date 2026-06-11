package com.self.opp_pro.Template;

public class Text {
    public static void main(String[] args) {
        People t = new Teacher();
        t.write();
        System.out.println("===========================================");
        People s = new Student();
        s.write();
    }
}
