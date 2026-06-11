package com.self.CollectionsFramework.Map.HashMap;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        //与HashSet一模一样是基于哈希表实现的
        //Set是基于Map实现的   不过Set至于要键的数据   故HashMap索引值与集合长度和键的哈希值有关
        //无排序无重复无索引

        Map<Student, String> map = new HashMap<>();
        map.put(new Student("小明",20,98.5),"第二");
        map.put(new Student("小明",20,98.5),"第一");
        map.put(new Student("小陈",23,90),"第二");
        map.put(new Student("小红",21,88),"第三");

        map.forEach((k,v) -> System.out.println(k+"\t"+v));
    }
}
