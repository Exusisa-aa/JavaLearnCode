package com.self.oop_pro.ExtendsVisit;

public class Z extends F{
    String name = "子类名字";
    @Override
    public void print(){
        System.out.println("子类方法被调用");
    }

    public void print1(){
        String name = "子类方法内名字";
        System.out.println(name);
        System.out.println(this.name);
        System.out.println(super.name);
        print();
        super.print();
    }
}
