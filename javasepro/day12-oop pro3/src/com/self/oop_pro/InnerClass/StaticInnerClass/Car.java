package com.self.oop_pro.InnerClass.StaticInnerClass;

public class Car {
    private static String name;
    private double speed;
    public void test1(){}

    private static void test2(){}

    public static class Engine{
        private static String name;
        public static void name(){}
        public static void print(){
             String name = "aa";
//            System.out.println(speed); 静态内方法只能调用外部静态成员，不能调用外部实例成员
            test2();
//            test1();
            System.out.println(name);
            System.out.println(Engine.name);
            System.out.println(Car.name);
        }
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Car.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
