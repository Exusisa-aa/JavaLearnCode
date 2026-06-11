package com.self.oop_pro.Generics.GenericsClass;

public class MyArrayList<E> {
    private Object[] objects = new Object[10];
    private int size = 0;
    public boolean add(E e){
        objects[size++] = e;
        return true;
    }
    public E get(int index){
        return (E)objects[index];
    }
}
