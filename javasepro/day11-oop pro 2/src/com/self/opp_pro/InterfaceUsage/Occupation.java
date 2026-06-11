package com.self.opp_pro.InterfaceUsage;

public class Occupation extends Student implements Singer,Drive{
    @Override
    public void drive(){
        System.out.println("我是一名司机");
    }

    @Override
    public void sing(){
        System.out.println("我是一名歌手");
    }
}
