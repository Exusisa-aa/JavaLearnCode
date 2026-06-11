package com.self.oop_pro.API.API_Object;

import java.util.Objects;

public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {//快捷键是tos
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    //this指调用方法的、对象，o代表被调用的对象，快捷键是equ
    public boolean equals(Object o) {
        //先判断调用方法的对象的地址和o的地址是否相等，若是直接返回true
        if (this == o) return true;
        //判断o对象是否为null，若是直接返回false
        //getClass用于判断两个对象的数据类型是否相同
        if (o == null || getClass() != o.getClass()) return false;
        //将object类强转为学生类
        Student student = (Student) o;
        //判断数据是否相等，相等则为true
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }


}
