package com.self.CollectionsFramework.Collection.HashCode;

import java.util.Arrays;

public class HashCodeDemo {
    //每个引用类型变量、对象都有一个哈希值，同一个变量、对象的哈希值相同
    //哈希值范围为-21亿-21亿  不同对象也有小概率发生哈希值相同（哈希碰撞）
    //hashCode方法可查看哈希值


    public static void main(String[] args) {
        String rs1 = "abc";
        Integer a = 20;
        int[] array = {2,3,4,5,6,7,8,9};

        Student s1 = new Student("小明",20,95);
        Student s2 = new Student("小红",21,92.5);

        System.out.println(rs1.hashCode());
        System.out.println(a.hashCode());
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(Arrays.hashCode(array));
    }
}
