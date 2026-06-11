package com.self.classHomework1;

public class Chinese extends Person{


    public Chinese(String name,String nationality){
        super(name,nationality);
    }


    @Override
    public String eat() {
        return "在用筷子吃饭";
    }

}
