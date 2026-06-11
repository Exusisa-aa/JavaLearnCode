package com.self.oop_pro.Enum.EnumExample;

public enum SexConstant {
    BOY("小明",18,"游戏"),GIRL("小红",17,"追星");

    private String name;
    private int age;
    private String hobby;

    SexConstant() {
    }

    SexConstant(String name, int age, String hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
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

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
