package com.self.CollectionsFramework.Collection.SetBasis.LinkedHashSet;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetDemo {
    //有序  不重复  无索引
    //基于哈希表与HashSet来实现的，会把存入的数据又以双链表的形式串联起来，每个元素记住上一元素与下一元素的地址，根节点还要记住上一元素与下一元素的地址，占用更多内存换来有序
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        System.out.println(set);
        for (String s : set) {
            System.out.println(s);
        }
    }
}
