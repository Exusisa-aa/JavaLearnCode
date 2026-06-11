package com.self.oop.startdemo;

public class CarType {
    public static void main(String[] args) {
        Car Apolo = new Car();
        Apolo.logo = "apolo";
        Apolo.name = "太阳神";
        Apolo.type = "11";
        Apolo.speed = 700;
        Apolo.price = 30000000;
        Apolo.print();
        Apolo.paid();

        Car Lamborghini = new Car();
        Lamborghini .logo = "lamborghini";
        Lamborghini .name = "毒药";
        Lamborghini .type = "3";
        Lamborghini .speed = 600;
        Lamborghini .price = 50000000;
        Lamborghini .print();
        Lamborghini .paid();

        System.out.println(Apolo);
        System.out.println(Lamborghini);
    }
}
