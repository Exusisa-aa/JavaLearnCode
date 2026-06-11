package com.self.classHomework2;

public class Duck extends Animal{


    public Duck() {
        super("鸭子");
    }
    @Override
    public void sound() {
        System.out.println("嘎~嘎~嘎~");
    }
}
