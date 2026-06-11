package com.self.opp_pro.Template;

public abstract class People {
    public final void write(){
        System.out.println("----------------------小作文------------------");
        System.out.println("-------------------开头------------------");
        System.out.println(writeMain());
        System.out.println("---------------结尾------------------");
    }

    public abstract String writeMain();
}
