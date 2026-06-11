package com.self.oop.javabean;

public class Student {
    private String name;
    private double score;

    public Student(){

    }

    public void setName(String name){
        this.name = name;
    }

    public void setScore(double score){
        if (score >= 0 && score <= 100){
            this.score = score;
        }else {
            System.out.println("输入有误");
        }
    }


    public String getName() {
        return this.name;
    }

    public double getScore(){
        return this.score;
    }
}
