package com.self.oop_pro.Extend;

public class B extends A{
    public void print3(){
        System.out.println(a);
        print1();
//        System.out.println(b); 只能调非私有
//        print2();
    }
}
