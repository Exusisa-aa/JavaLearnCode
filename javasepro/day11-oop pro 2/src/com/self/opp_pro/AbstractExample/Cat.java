package com.self.opp_pro.AbstractExample;

public class Cat extends Animal{

    public Cat(){

    }

    public Cat(String name){
        super(name);
    }

    @Override
    public void cry(){
        System.out.println(getName() + "喵喵喵");
    }

    public void name1(){
        System.out.println("这是猫");
    }
}
