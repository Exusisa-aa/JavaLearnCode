package com.self.opp_pro.AbstractExample;

public class Dog extends Animal{

    public Dog(){

    }

    public Dog(String name){
        super(name);
    }
    @Override
    public void cry(){
        System.out.println(getName() + "汪汪汪");
    }

    public void name2(){
        System.out.println("这是狗");
    }
}
