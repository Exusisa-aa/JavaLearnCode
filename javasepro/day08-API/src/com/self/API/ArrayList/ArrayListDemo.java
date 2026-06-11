package com.self.API.ArrayList;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
//        1.ArrayList的创建
        ArrayList rs1 = new ArrayList();
        ArrayList<String> rs2 = new ArrayList<>();
//        2.添加元素至末尾并返回布尔值
        rs1.add("123");
        rs1.add(123);
        rs1.add(52.5);
        rs1.add('a');
        System.out.println(rs1.add(52.5));
        System.out.println(rs1);
        System.out.println("----------------------------------------------");
//        3.在指定的位置添加元素，不返回
        rs1.add(0,"b");
        System.out.println(rs1);
        System.out.println("----------------------------------------------");
//        4.返回指定位置的元素
        System.out.println(rs1.get(3));
        System.out.println("----------------------------------------------");
//        5.返回集合的个数
        System.out.println(rs1.size());
        System.out.println("----------------------------------------------");
//        6.删除指定元素，返回被删除的元素
        System.out.println(rs1.remove(0));
        System.out.println(rs1);
        System.out.println("----------------------------------------------");
//        7.删除指定元素并返回删除是否成功,若有相同，则删除第一个
        System.out.println(rs1.remove(52.5));
        System.out.println(rs1);
        System.out.println("----------------------------------------------");
//        8.修改指定位置元素，返回被修改的元素
        System.out.println(rs1.set(0,456));
        System.out.println(rs1);
    }
}
