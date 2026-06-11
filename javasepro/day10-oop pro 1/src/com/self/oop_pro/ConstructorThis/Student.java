package com.self.oop_pro.ConstructorThis;

public class Student {
    private String name;
    private int age;
    private String School;

    public Student() {
    }


    public Student(String name,int age){
        this(name,age,"家里蹲大学");
    }

    public Student(String name, int age, String school) {
        this.name = name;
        this.age = age;
        School = school;
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

    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        School = school;
    }
}
