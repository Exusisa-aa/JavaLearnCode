package com.self.classHomework1;

public class American extends Person{


    public American(String name,String nationality){
        super(name,nationality);
    }



    @Override
    public String eat() {
        return "在用刀叉吃饭";
    }
}
