package com.self.opp_pro.PolymorphismUsage;

public class Student extends People{
    String occupation = "学生";
    @Override
    public void run(){
        System.out.println("学生跑得快");
    }

    public void text(){
        System.out.println("考试");
    }
}
