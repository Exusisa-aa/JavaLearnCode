package com.self.CollectionsFramework.Map.LinkedHashMap;

import com.self.CollectionsFramework.Map.HashMap.Student;


import java.net.InetAddress;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        //与LinkedHashSet一模一样，基于哈希表和双链表实现的
        //LinkedHashSet是基于LinkedHashMap实现的
        //有序无重复无索引
        Map<Student, String> map = new LinkedHashMap<>();
        map.put(new Student("小明",20,98.5),"第一");
        map.put(new Student("小陈",23,90),"第二");
        map.put(null,"第四");
        map.put(new Student("小红",21,88),"第三");
        map.put(new Student("小红",21,88),"第五");



        map.forEach((k,v) -> System.out.println(k+"\t"+v));
    }
}
