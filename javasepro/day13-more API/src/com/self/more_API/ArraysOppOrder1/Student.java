package com.self.more_API.ArraysOppOrder1;

public class Student implements Comparable<Student>{
    private String name;
    private int age;
    private double score;

    public Student() {
    }

    public Student(String name, int age, double score) {
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(this.getScore(),o.getScore());

//        return Double.compare(o.getScore(),this.getScore()); 先右后左为降序

//        if(this.getScore() > o.getScore()){

//            return 1; //左大于右返回正整数为升序
//        } else if (this.getScore() < o.getScore()) {
//            return -1;
//        }
//        return 0;


//        if(this.getScore() > o.getScore()){
//            return -1; //左大于右返回负整数为降序
//        } else if (this.getScore() < o.getScore()) {
//            return 1;
//        }
//        return 0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
