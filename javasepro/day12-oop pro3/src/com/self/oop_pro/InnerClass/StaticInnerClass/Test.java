package com.self.oop_pro.InnerClass.StaticInnerClass;

public class Test {
    public static void main(String[] args) {
        Car.Engine s = new Car.Engine();
        s.print();
        Car.Engine.name();
        Car.Engine.print();
    }
}
