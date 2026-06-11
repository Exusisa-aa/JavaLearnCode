package com.self.oop_pro.API.API_Object;

import java.util.Arrays;

public class CloneDeep implements Cloneable{
    private String name;
    private int age;
    private double[] score;

    public CloneDeep() {
    }

    public CloneDeep(String name, int age, double[] score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double[] getScore() {
        return score;
    }

    public void setScore(double[] score) {
        this.score = score;
    }

    //深克隆；内部地址不同的克隆
    @Override
    protected Object clone() throws CloneNotSupportedException {
        CloneDeep a = (CloneDeep) super.clone();
        a.score = a.score.clone();
        return a;
    }

    @Override
    public String toString() {
        return "Clone{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + Arrays.toString(score) +
                '}';
    }
}
