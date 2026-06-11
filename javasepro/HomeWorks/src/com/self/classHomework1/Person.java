package com.self.classHomework1;

public class Person {
    protected String name;
    protected String nationality;

    public Person() {
    }

    public Person(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    public String eat(){
        return "吃饭";
    }

    @Override
    public String toString() {
        return nationality + "人" + name + eat();
    }
}
