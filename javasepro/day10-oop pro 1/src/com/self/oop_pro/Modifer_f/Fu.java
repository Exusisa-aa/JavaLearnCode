package com.self.oop_pro.Modifer_f;

public class Fu {
    private void privateMethod(){
        System.out.println("private");
    }

    void Method(){
        System.out.println("缺省");
    }

    protected void protectedMethod(){
        System.out.println("protected");
    }

    public void publicMethod(){
        System.out.println("public");
    }

    public  void print(){
        privateMethod();
        Method();
        protectedMethod();
        publicMethod();
    }
}
