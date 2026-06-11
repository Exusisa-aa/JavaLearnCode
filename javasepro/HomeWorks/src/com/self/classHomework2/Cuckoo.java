package com.self.classHomework2;

public class Cuckoo extends Animal implements Flyable{

    public Cuckoo() {
        super("布谷鸟");
    }
    @Override
    public void sound() {
        System.out.println("布谷~布谷~布谷~");
    }

    @Override
    public void fly() {
        System.out.println("马赫速度飞行中");
    }
}
