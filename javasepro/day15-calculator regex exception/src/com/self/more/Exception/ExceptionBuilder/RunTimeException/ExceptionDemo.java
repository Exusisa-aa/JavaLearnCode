package com.self.more.Exception.ExceptionBuilder.RunTimeException;

public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            age(20);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void age(int age){
        if(age > 0 && age < 150){
            System.out.println("年龄输入成功");
        }else {
            throw new IllegalAgeException("/age is illegal,out of range");
        }
    }
}
