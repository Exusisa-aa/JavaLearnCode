package com.self.learnFile.pojo;

import java.time.LocalDateTime;

public class Student {
    private String name;
    private int age;
    private char gender;
    private double score;
    private LocalDateTime time;
    private int dep_zi_id;
    private int id;
    private int user_id;

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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getDep_zi_id() {
        return dep_zi_id;
    }

    public void setDep_zi_id(int dep_zi_id) {
        this.dep_zi_id = dep_zi_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", score=" + score +
                ", time=" + time +
                ", dep_zi_id=" + dep_zi_id +
                ", id=" + id +
                ", user_id=" + user_id +
                '}';
    }
}
