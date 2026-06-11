package com.self.oop_pro.Rewrite;

public class Student {
    private String name;
    private int age;

    public Student(){

    }

    public Student(String name,int age){
        this.age = age;
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public void print1(){
        System.out.println("111");
    }

    public void print2(String name,int age){
        System.out.println(name+age);
    }

    @Override
    public String toString(){
        return "Student{neme:" + name + ",age:" + age + "}";
    }



}
