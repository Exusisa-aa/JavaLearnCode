package com.self.oop_pro.StaticVarExample;

public class User {
    public static int number;
    int age;
    public User(){
        User.number++;
    }

    public User(int age){
        number++;
    }

}
