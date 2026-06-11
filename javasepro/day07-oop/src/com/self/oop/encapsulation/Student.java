package com.self.oop.encapsulation;

public class Student {
    private String name;
    private double score;

    public void setName(String name){
        this.name = name;
    }
    public void setScore(double score){
        if (score >= 0 && score <= 100){
            this.score = score;
        }else {
            System.out.println("数据有误");
        }
    }

    public double getScore(){
        return this.score;
    }

    public void printPass(){
        System.out.println(this.score >= 60?name+"及格":name+"不及格");
    }
}
