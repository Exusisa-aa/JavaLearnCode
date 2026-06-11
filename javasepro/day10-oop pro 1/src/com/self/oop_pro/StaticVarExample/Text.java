package com.self.oop_pro.StaticVarExample;

public class Text {
    public static void main(String[] args) {
        User s1 = new User();
        User s2 = new User();
        User s3 = new User();
        User s4 = new User(18);
        User s5 = new User(19);
        User s6 = new User(20);

        System.out.println("一共创建了" + User.number + "个对象");
    }

}
