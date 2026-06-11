package com.self.CollectionsFramework.Collection.CollectionMoreAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionMoreAPIDemo {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        //1.给指定集合添加对象
        c.add("java1");
        c.add("java1");
        c.add("java2");
        c.add("java3");
        System.out.println(c);
        System.out.println("-----------------------------");
        //2.清空集合中的所有元素
//        c.clear();
        System.out.println(c);
        System.out.println("-----------------------------");
        //3.把给定对象在当前集合中删除
        c.remove("java1");
        System.out.println(c);
        System.out.println("-----------------------------");
        //4.判断当前集合是否存在给定对象
        System.out.println(c.contains("java2"));
        System.out.println("-----------------------------");
        //5.判断集合是否为空集合
        System.out.println(c.isEmpty());
        System.out.println("-----------------------------");
        //6.返回当前元素的个数
        System.out.println(c.size());
        System.out.println("-----------------------------");
        //7.把集合中的元素转为一个数组
        Object[] o = c.toArray();
        System.out.println(Arrays.toString(o));
        String[] s = new String[c.size()];
        c.toArray(s);
        System.out.println(Arrays.toString(s));
        System.out.println("-----------------------------");
        //8.往集合中添加另一个集合的所有元素
        Collection<String> c1 = new ArrayList<>();
        c1.addAll(c);
        System.out.println(c1);
    }
}
