package com.self.CollectionsFramework.Collection.SetBasis.TreeSet;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
    //可排序  不重复  无索引
    //基于红黑树实现
    public static void main(String[] args) {
        Set<Integer> set1 = new TreeSet<>();
        set1.add(5);
        set1.add(2);
        set1.add(1);
        set1.add(3);
        set1.add(4);
        System.out.println(set1);
        System.out.println("------------------------------------");
        Set<String> set2 = new TreeSet<>(String::compareToIgnoreCase);
        set2.add("zhang");
        set2.add("chen");
        set2.add("wang");
        set2.add("Zed");
        System.out.println(set2);
        System.out.println("-------------------------------------");
        Set<Student> set3 = new TreeSet<>(Comparator.comparing(Student::getName));

        Student s1 = new Student("陈",20,170.5);
        Student s2 = new Student("张",23,169.57);
        Student s3 = new Student("王",20,160.24);
        Student s4 = new Student("万",25,180.13);
        set3.add(s1);
        set3.add(s2);
        set3.add(s3);
        set3.add(s4);
        System.out.println(set3);
    }
}
