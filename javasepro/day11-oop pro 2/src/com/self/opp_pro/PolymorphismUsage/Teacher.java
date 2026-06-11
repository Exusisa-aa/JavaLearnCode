package com.self.opp_pro.PolymorphismUsage;

public class Teacher extends People{
    String occupation = "老师";
    @Override
    public void run(){
        System.out.println("老师跑的气喘吁吁");
    }

    public void teach(){
        System.out.println("教学");
    }
}
