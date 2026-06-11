package com.self.oop_pro.Generics.GenericsMethod;

import java.util.ArrayList;

public class test {
    public<E> E test1(E e){
        return e;
    }

    public static <T extends Car> T test2(T t){ //继承后进来的必须是Car及其子类
        return t;
    }

    public void test3(ArrayList<?> list){}

    public void test4(ArrayList<? extends Car> list){}

    public void test5(ArrayList<? super Car> list){}
}
