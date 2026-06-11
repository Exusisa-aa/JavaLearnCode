package com.self.Advanced.Reflection.FrameExample;

public class Student {
    private String name;
    private int age;
    private String semester;

    public Student() {
    }

    public Student(String name, int age, String semester) {
        this.name = name;
        this.age = age;
        this.semester = semester;
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

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", semester='" + semester + '\'' +
                '}';
    }
}
