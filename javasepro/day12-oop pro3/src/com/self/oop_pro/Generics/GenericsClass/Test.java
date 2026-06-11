package com.self.oop_pro.Generics.GenericsClass;

public class Test {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("123");
        list.add("456");
        System.out.println(list.get(1));
        MyClass<Cat,Dog,String> myClass = new MyClass<>();
        Zoo<Dog,Cat,Animal> zoo = new Zoo<>();
//        Zoo<Dog,String,Animal> zoo = new Zoo<>(); 由于已继承Animal 故只能用Animal与其子类
    }
}
