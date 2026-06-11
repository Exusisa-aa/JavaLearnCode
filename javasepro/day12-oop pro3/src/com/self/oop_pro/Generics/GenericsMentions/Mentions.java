package com.self.oop_pro.Generics.GenericsMentions;

import java.util.ArrayList;

public class Mentions {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("vvv1");
        list.add("vvv2");
        list.add("vvv3");
        System.out.println(list.get(1));
        //泛型只在在编译阶段工作，一旦成为class文件，class文件中不存在泛型，而是基于objects（arraylist）的执行工作执行，这叫泛型擦除
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(12);
        ArrayList<Double> list2 = new ArrayList<>();
        list2.add(12.5);
        //泛型不支持基本数据类型，只支持引用数据类型，
    }
}
