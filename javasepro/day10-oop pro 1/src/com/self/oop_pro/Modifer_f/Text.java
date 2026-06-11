package com.self.oop_pro.Modifer_f;

public class Text {
    public void text() {
        Fu f = new Fu();
        f.protectedMethod();
        f.publicMethod();
        f.Method();
//        f.privateMethod(); private只能在类中访问
    }
}
