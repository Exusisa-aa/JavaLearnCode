package com.self.oop_pro.Rewrite;

public class A extends Student{
    @Override
    public void print1(){
        System.out.println("sss");
    }

    @Override
    public void print2(String name,int age){
        System.out.println("名字:" + name + ",年龄:" + age);
    }
}
