package com.self.classHomework1;

public class Indian extends Person{


    public Indian(String name,String nationality){
        super(name,nationality);
    }


    @Override
    public String eat() {
        return "在用手抓饭吃";
    }
}
