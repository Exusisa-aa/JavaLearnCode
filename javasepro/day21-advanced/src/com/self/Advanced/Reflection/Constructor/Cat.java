package com.self.Advanced.Reflection.Constructor;

public class Cat {
    private String name;
    private int age;
    private double weight;

    public Cat() {
    }

    private Cat(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}
