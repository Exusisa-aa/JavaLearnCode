package com.self.CollectionsFramework.Map.TreeMap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        //与TreeSet一模一样是基于红黑树实现的
        //默认升序排序无重复无索引

        Map<Student, String> map = new TreeMap<>((o1, o2) -> Double.compare(o2.getScore(),o1.getScore()));
        map.put(new Student("小明",20,98.5),"第二");
        map.put(new Student("小明",20,98.5),"第一");
        map.put(new Student("小陈",23,90),"第二");
        map.put(new Student("小红",21,88),"第三");

        map.forEach((k,v) -> System.out.println(k+"\t"+v));
    }
}
