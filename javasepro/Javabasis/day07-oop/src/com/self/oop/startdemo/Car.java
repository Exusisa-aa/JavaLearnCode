package com.self.oop.startdemo;

public class Car {
    String name;
    double speed;
    String logo;
    String type;
    int price;

    public void print() {
        System.out.println(logo + name + type + "的车速达到了惊人的" + speed + "千米每小时");
    }

    public void paid() {
        System.out.println(logo + name + type + "的价格为" + price + "元");
    }

}

