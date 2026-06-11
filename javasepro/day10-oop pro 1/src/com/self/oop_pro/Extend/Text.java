package com.self.oop_pro.Extend;

public class Text {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.a);
        b.print1();
        //        System.out.println(b); 只能调非私有
//        print2();
        b.print3();
    }
}
