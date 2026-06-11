package com.self.more.Exception.ExceptionBuilder.WritingException;


public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            age(20);
        } catch (IllegalAgeException e) {
            throw new RuntimeException(e);
        }
    }

    public static void age(int age) throws IllegalAgeException{
        if(age > 0 && age < 150){
            System.out.println("年龄输入成功");
        }else {
            throw new IllegalAgeException("/age is illegal,out of range");
        }
    }
}
