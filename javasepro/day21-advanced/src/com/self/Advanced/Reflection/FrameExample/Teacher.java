package com.self.Advanced.Reflection.FrameExample;

public class Teacher {
    private String name;
    private int age;
    private String Tec;

    public Teacher() {
    }

    public Teacher(String name, int age, String tec) {
        this.name = name;
        this.age = age;
        Tec = tec;
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

    public String getTec() {
        return Tec;
    }

    public void setTec(String tec) {
        Tec = tec;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", Tec='" + Tec + '\'' +
                '}';
    }
}
