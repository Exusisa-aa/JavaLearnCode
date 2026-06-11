package com.self.CollectionsFramework.Collection.CollectionsAPI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsAPIDemo {
    public static void main(String[] args) {
        //1.添加批量元素
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"小明","小红","小刚","小陈");
        System.out.println(list);
        System.out.println("------------------------------------");
        //2.打乱元素的顺序
        Collections.shuffle(list);
        System.out.println(list);
        System.out.println("------------------------------------");
        //3.默认升序排序
        List<Integer> list1 = new ArrayList<>();
        Collections.addAll(list1,1,2,3,4,5,9,8,5,1,3);
        Collections.sort(list1);
        System.out.println(list1);
        System.out.println("------------------------------------");
        //4.制定规则对象排序
        List<Student> list2 = new ArrayList<>();
        list2.add(new Student("小明",20,95));
        list2.add(new Student("小红",21,92.5));
        list2.add(new Student("小刚",21,92.5));
        Collections.sort(list2);
        Collections.sort(list2, Comparator.comparing(Student::getAge));
        System.out.println(list2);
        System.out.println("------------------------------------");
    }
}
