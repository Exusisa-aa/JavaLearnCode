package com.self.oop_pro.InnerClass.MemberInnerClass;

public class Car {
    private String name;
    private double speed;

    public void run(){
        System.out.println("外部类方法被使用");
    }


    public class Engine {
        private double speed;
        public void run(){
            System.out.println("成员内部类方法被使用");
        }

        public void print(){
            double speed = 20;
            System.out.println(speed);
            System.out.println(Engine.this.speed);
            System.out.println(Car.this.speed);
        }


    }

    public Car() {
    }

    public Car(String name, double speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
