package com.self.classHomework2;

public class Cat extends Animal{

    public Cat(){
        super("猫");
    }

    @Override
    public void sound(){
        System.out.println("喵~喵~喵~");
    }
}
