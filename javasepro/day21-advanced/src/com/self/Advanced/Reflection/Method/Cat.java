package com.self.Advanced.Reflection.Method;

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

    public String eat(String food){
        return this.name + "在吃" + food;
    }

    public void run(){
        System.out.println(this.name + "在跑");
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
